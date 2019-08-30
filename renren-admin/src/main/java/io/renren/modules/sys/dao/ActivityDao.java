package io.renren.modules.sys.dao;

import io.renren.modules.sys.entity.ActivityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 活动
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:20:59
 */
@Mapper
public interface ActivityDao extends BaseMapper<ActivityEntity> {

    void insertActivity(ActivityEntity activityEntity);





}
