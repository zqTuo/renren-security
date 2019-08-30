package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.AdvertisersEntity;
import io.renren.modules.sys.entity.CodeEntity;
import io.renren.modules.sys.entity.OrderEntity;
import org.springframework.data.redis.core.query.QueryUtils;

import java.util.Map;

/**
 * 广告主
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:16:27
 */
public interface AdvertisersService extends IService<AdvertisersEntity> {

    PageUtils queryPage(Map<String, Object> params);


    void insert(AdvertisersEntity entity);


    void createQrCode(OrderEntity orderEntity);
}

