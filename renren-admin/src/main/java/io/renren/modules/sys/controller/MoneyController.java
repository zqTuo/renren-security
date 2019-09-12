package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.MoneyEntity;
import io.renren.modules.sys.service.MoneyService;
import io.renren.common.PageUtils;
import io.renren.common.R;



/**
 * 押金
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-10 16:23:30
 */
@RestController
@RequestMapping("sys/money")
public class MoneyController {
    @Autowired
    private MoneyService moneyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:money:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = moneyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{moneyId}")
    @RequiresPermissions("sys:money:info")
    public R info(@PathVariable("moneyId") Long moneyId){
        MoneyEntity money = moneyService.getById(moneyId);

        return R.ok().put("money", money);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:money:save")
    public R save(@RequestBody MoneyEntity money){
        moneyService.save(money);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:money:update")
    public R update(@RequestBody MoneyEntity money){
        ValidatorUtils.validateEntity(money);
        moneyService.updateById(money);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:money:delete")
    public R delete(@RequestBody Long[] moneyIds){
        moneyService.removeByIds(Arrays.asList(moneyIds));

        return R.ok();
    }

}
