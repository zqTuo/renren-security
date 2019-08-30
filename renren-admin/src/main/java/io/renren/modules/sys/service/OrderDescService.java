package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.OrderDescEntity;

import java.util.Map;

/**
 * 订单详情
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-30 17:53:00
 */
public interface OrderDescService extends IService<OrderDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

