package io.renren.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.common.PageUtils;
import io.renren.common.R;
import io.renren.common.validator.ValidatorUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.BonusEntity;
import io.renren.service.BonusService;

import javax.swing.*;


/**
 * 奖金池
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-19 11:03:50
 */
@RestController
@RequestMapping("api/bonus")
@Api(tags="奖品池")
public class BonusController {
    @Autowired
    private BonusService bonusService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bonusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bonusId}")
    public R info(@PathVariable("bonusId") Long bonusId){
        BonusEntity bonus = bonusService.getById(bonusId);

        return R.ok().put("bonus", bonus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BonusEntity bonus){
        bonusService.save(bonus);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BonusEntity bonus){
        ValidatorUtils.validateEntity(bonus);
        bonusService.updateById(bonus);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] bonusIds){
        bonusService.removeByIds(Arrays.asList(bonusIds));

        return R.ok();
    }
    @RequestMapping("/game")
    public R ganme(){
//        获取所有的奖品
        List<BonusEntity> BonusEntityList = bonusService.list();

//        获取所有奖品的概率
        List<Double> orignalRates = new ArrayList<>();
        for (BonusEntity bonusEntity : BonusEntityList) {
            orignalRates.add(Double.valueOf(bonusEntity.getBonusGailv()));
        }
        bonusService.BigGame(BonusEntityList,orignalRates);

        return R.ok();

    }
}
