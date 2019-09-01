package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.utils.IdWorker;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.entity.CodeEntity;
import io.renren.modules.sys.entity.OrderEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.AdvertisersEntity;
import io.renren.modules.sys.service.AdvertisersService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 广告主
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:16:27
 */
@RestController
@RequestMapping("sys/advertisers")
public class AdvertisersController {
    @Autowired
    private AdvertisersService advertisersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:advertisers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = advertisersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{advertisersId}")
    @RequiresPermissions("sys:advertisers:info")
    public R info(@PathVariable("advertisersId") String advertisersId){
        AdvertisersEntity advertisers = advertisersService.getById(advertisersId);

        return R.ok().put("advertisers", advertisers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:advertisers:save")
    public R save(@RequestBody AdvertisersEntity advertisers){
        IdWorker idworker=new IdWorker(0,1);
        String s = idworker.nextId() + "";
        advertisers.setAdvertisersId(s);
        advertisersService.insert(advertisers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:advertisers:update")
    public R update(@RequestBody AdvertisersEntity advertisers){
        ValidatorUtils.validateEntity(advertisers);
        advertisersService.updateById(advertisers);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:advertisers:delete")
    public R delete(@RequestBody String[] advertisersIds){
        advertisersService.removeByIds(Arrays.asList(advertisersIds));

        return R.ok();
    }

//    批量生成二维码
    @RequestMapping("/QrCode")
    @RequiresPermissions("sys:advertisers:QrCode")
    public R QrCode(@RequestBody OrderEntity orderEntity ) {

        advertisersService.createQrCode(orderEntity);
        return R.ok();
    }

}
