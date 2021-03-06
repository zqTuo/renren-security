package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.sys.entity.OrderDescEntity;
import io.renren.modules.sys.service.OrderDescService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.OrderEntity;
import io.renren.modules.sys.service.OrderService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 09:14:53
 */
@RestController
@RequestMapping("sys/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDescService orderDescService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:Order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderId}")
    @RequiresPermissions("sys:Order:info")
    public R info(@PathVariable("orderId") Long orderId){
        OrderEntity order = orderService.getById(orderId);

        List<OrderDescEntity> detailList = orderDescService.list(
                new QueryWrapper<OrderDescEntity>().eq("order_id",orderId));

        Map<String,Object> map = new HashMap<>();
        map.put("detailList",detailList);
        map.put("order",order);
        return R.ok(map);
    }



    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:Order:save")
    public R save(@RequestBody OrderEntity order){
        orderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:Order:update")
    public R update(@RequestBody OrderEntity order){
        ValidatorUtils.validateEntity(order);
        orderService.updateById(order);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:Order:delete")
    public R delete(@RequestBody Long[] orderIds){
        orderService.removeByIds(Arrays.asList(orderIds));

        return R.ok();
    }

}
