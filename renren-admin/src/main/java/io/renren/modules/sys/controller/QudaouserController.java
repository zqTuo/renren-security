package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.PageUtils;
import io.renren.common.R;
import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.QudaouserEntity;
import io.renren.modules.sys.service.QudaouserService;




/**
 * 渠道用户管理
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-18 17:33:31
 */
@RestController
@RequestMapping("sys/qudaouser")
public class QudaouserController {
    @Autowired
    private QudaouserService qudaouserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:qudaouser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qudaouserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{qudaoId}")
    @RequiresPermissions("sys:qudaouser:info")
    public R info(@PathVariable("qudaoId") Long qudaoId){
        QudaouserEntity qudaouser = qudaouserService.getById(qudaoId);

        return R.ok().put("qudaouser", qudaouser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:qudaouser:save")
    public R save(@RequestBody QudaouserEntity qudaouser){
        qudaouserService.save(qudaouser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:qudaouser:update")
    public R update(@RequestBody QudaouserEntity qudaouser){
        ValidatorUtils.validateEntity(qudaouser);
        qudaouserService.updateById(qudaouser);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:qudaouser:delete")
    public R delete(@RequestBody Long[] qudaoIds){
        qudaouserService.removeByIds(Arrays.asList(qudaoIds));

        return R.ok();
    }

}
