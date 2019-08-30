package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.CodeEntity;
import io.renren.modules.sys.service.CodeService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 二维码管理
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:10:41
 */
@RestController
@RequestMapping("sys/code")
public class CodeController {
    @Autowired
    private CodeService codeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:code:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = codeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{codeId}")
    @RequiresPermissions("sys:code:info")
    public R info(@PathVariable("codeId") Integer codeId){
        CodeEntity code = codeService.getById(codeId);

        return R.ok().put("code", code);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:code:save")
    public R save(@RequestBody CodeEntity code){
        codeService.save(code);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:code:update")
    public R update(@RequestBody CodeEntity code){
        ValidatorUtils.validateEntity(code);
        codeService.updateById(code);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:code:delete")
    public R delete(@RequestBody Integer[] codeIds){
        codeService.removeByIds(Arrays.asList(codeIds));

        return R.ok();
    }
}
