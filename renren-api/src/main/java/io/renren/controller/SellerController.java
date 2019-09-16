package io.renren.controller;

import io.renren.common.IdWorker;
import io.renren.common.PageUtils;
import io.renren.common.R;
import io.renren.common.Result;
import io.renren.common.validator.ValidatorUtils;
import io.renren.entity.MoneyEntity;
import io.renren.entity.SellerEntity;
import io.renren.service.MoneyService;
import io.renren.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


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

    @Resource
    private SellerService sellerService;
    @Autowired
    private MoneyService moneyService;
    @Resource
    private IdWorker idWorker;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list() {
//        PageUtils page = sellerService.queryPage(params);
        List<SellerEntity>sellerList=sellerService.list();
        return R.ok().put("page", sellerList);
    }




    /**
     * 保存
     */
    @RequestMapping("/save")
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
        moneyEntity.setMoneyYajin(BigDecimal.valueOf(300));
        moneyService.save(moneyEntity);
        return R.ok().put("id",id);
    }



}
