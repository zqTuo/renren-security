package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.OrderDescEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单详情
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-30 17:53:00
 */
@Mapper
public interface OrderDescDao extends BaseMapper<OrderDescEntity> {

    void insertOrderDescEntity(OrderDescEntity descEntity);

}
