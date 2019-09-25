package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.ActivityEntity;

import java.util.Map;

/**
 * 活动
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:20:59
 */
public interface ActivityService extends IService<ActivityEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void insert(ActivityEntity activity);

}

