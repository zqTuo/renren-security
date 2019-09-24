package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.IdWorker;
import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.ActivityEntity;
import io.renren.modules.sys.service.ActivityService;
import io.renren.common.PageUtils;
import io.renren.common.R;


/**
 * 活动
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:20:59
 */
@RestController
@RequestMapping("sys/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:activity:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = activityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{activityId}")
    @RequiresPermissions("sys:activity:info")
    public R info(@PathVariable("activityId") String activityId){
        ActivityEntity activity = activityService.getById(activityId);

        return R.ok().put("activity", activity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:activity:save")
    public R save(@RequestBody ActivityEntity activity){
        //校验类型
        ValidatorUtils.validateEntity(activity);
        IdWorker idworker=new IdWorker(0,1);
        String s = idworker.nextId() + "";
        activity.setActivityId(s);
        activityService.insert(activity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:activity:update")
    public R update(@RequestBody ActivityEntity activity){
        ValidatorUtils.validateEntity(activity);
        activityService.updateById(activity);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:activity:delete")
    public R delete(@RequestBody String[] activityIds){
        activityService.removeByIds(Arrays.asList(activityIds));

        return R.ok();
    }

}
