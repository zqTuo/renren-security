package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.BonusEntity;
import io.renren.modules.sys.service.BonusService;



/**
 * 奖金池
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-19 11:03:50
 */
@RestController
@RequestMapping("sys/bonus")
public class BonusController {
    @Autowired
    private BonusService bonusService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:bonus:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bonusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bonusId}")
    @RequiresPermissions("sys:bonus:info")
    public R info(@PathVariable("bonusId") Long bonusId){
        BonusEntity bonus = bonusService.getById(bonusId);

        return R.ok().put("bonus", bonus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:bonus:save")
    public R save(@RequestBody BonusEntity bonus){
        //校验类型
        ValidatorUtils.validateEntity(bonus);
        bonusService.save(bonus);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:bonus:update")
    public R update(@RequestBody BonusEntity bonus){
        ValidatorUtils.validateEntity(bonus);
        bonusService.updateById(bonus);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:bonus:delete")
    public R delete(@RequestBody Long[] bonusIds){
        bonusService.removeByIds(Arrays.asList(bonusIds));

        return R.ok();
    }

//    根据订单id查询奖品
    @RequestMapping("/findBonusById/{orderId}")
    @RequiresPermissions("sys:bonus:orderId")
    public R findBonusById(@PathVariable("orderId") String orderId){
        List<BonusEntity> entityList = bonusService.list(new QueryWrapper<BonusEntity>().eq("order_id", orderId));

        return R.ok().put("bonus", entityList);
    }

}
