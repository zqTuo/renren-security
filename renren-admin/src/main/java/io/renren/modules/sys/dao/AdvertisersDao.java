package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.AdvertisersEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 广告主
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:16:27
 */
@Mapper
public interface AdvertisersDao extends BaseMapper<AdvertisersEntity> {

    void insertAdvertisersEntity(AdvertisersEntity entity);
}
