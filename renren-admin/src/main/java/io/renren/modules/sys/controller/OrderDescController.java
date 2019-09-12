package io.renren.modules.sys.controller;

import java.util.Arrays;

import java.util.List;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.OrderDescEntity;
import io.renren.modules.sys.service.OrderDescService;
import io.renren.common.PageUtils;
import io.renren.common.R;



/**
 * 订单详情
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-30 17:53:00
 */
@RestController
@RequestMapping("sys/orderdesc")
public class OrderDescController {
    @Autowired
    private OrderDescService orderDescService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:orderdesc:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderDescService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:orderdesc:info")
    public R info(@PathVariable("id") Long id){
        OrderDescEntity orderDesc = orderDescService.getById(id);

        return R.ok().put("orderDesc", orderDesc);
    }

    /*
     * 根据订单id查找订单详情数据
     * */
    @RequestMapping("/findAllByOrderId/{orderId}")
    @RequiresPermissions("sys:Order:findAllByOrderId")
    public R findAllByOrderId(@PathVariable("orderId") String orderId){

       List<OrderDescEntity> OrderDescList = orderDescService.findAllByOrderId(orderId);

        return R.ok().put("OrderDescList", OrderDescList);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:orderdesc:save")
    public R save(@RequestBody OrderDescEntity orderDesc){
        orderDescService.save(orderDesc);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:orderdesc:update")
    public R update(@RequestBody OrderDescEntity orderDesc){
        ValidatorUtils.validateEntity(orderDesc);
        orderDescService.updateById(orderDesc);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:orderdesc:delete")
    public R delete(@RequestBody Long[] ids){
        orderDescService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
