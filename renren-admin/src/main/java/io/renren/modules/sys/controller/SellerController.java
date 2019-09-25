package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;


import io.renren.common.utils.IdWorker;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.entity.MoneyEntity;
import io.renren.modules.sys.service.MoneyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.SellerEntity;
import io.renren.modules.sys.service.SellerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 商家
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:19:22
 */
@RestController
@RequestMapping("sys/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;
    @Autowired
    private MoneyService moneyService;
    @Autowired
    private IdWorker idWorker;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:seller:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sellerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sellerId}")
    @RequiresPermissions("sys:seller:info")
    public R info(@PathVariable("sellerId") String sellerId) {
        SellerEntity seller = sellerService.getById(sellerId);

        return R.ok().put("seller", seller);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:seller:save")
    public R save(@RequestBody SellerEntity seller) {
        Long s = idWorker.nextId();
        seller.setSellerId(String.valueOf(s));
        seller.setCreateTime(new Date());
        String conversionRate = seller.getConversionRate();
        String s1 = conversionRate + "%";
        seller.setConversionRate(s1);
        sellerService.save(seller);
        MoneyEntity moneyEntity = new MoneyEntity();
        long id = idWorker.nextId();
        moneyEntity.setMoneyId(String.valueOf(id));
        moneyEntity.setSellerId(String.valueOf(s));
        moneyEntity.setSellerName(seller.getNickName());
        moneyEntity.setCreateTime(new Date());
        moneyEntity.setPayStatus("1");
        moneyEntity.setMoneyYajin("300");
        moneyService.save(moneyEntity);
        return R.ok().put("id",id);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:seller:update")
    public R update(@RequestBody SellerEntity seller) {
        ValidatorUtils.validateEntity(seller);
        sellerService.updateById(seller);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:seller:delete")
    public R delete(@RequestBody String[] sellerIds) {
        sellerService.removeByIds(Arrays.asList(sellerIds));

        return R.ok();
    }


}
