package io.renren.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.BonusLogEntity;
import io.renren.service.BonusLogService;



/**
 * 中奖记录
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-19 11:03:50
 */
@RestController
@RequestMapping("api/bonuslog")
@Api(tags="奖品领取日记")
public class BonusLogController {
    @Autowired
    private BonusLogService bonusLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bonusLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{blId}")
    public R info(@PathVariable("blId") Long blId){
        BonusLogEntity bonusLog = bonusLogService.getById(blId);

        return R.ok().put("bonusLog", bonusLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BonusLogEntity bonusLog){
        bonusLogService.save(bonusLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BonusLogEntity bonusLog){
        ValidatorUtils.validateEntity(bonusLog);
        bonusLogService.updateById(bonusLog);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] blIds){
        bonusLogService.removeByIds(Arrays.asList(blIds));

        return R.ok();
    }

}
