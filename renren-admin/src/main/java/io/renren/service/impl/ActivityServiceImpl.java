package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.PageUtils;
import io.renren.common.Query;

import io.renren.modules.sys.dao.ActivityDao;
import io.renren.modules.sys.entity.ActivityEntity;
import io.renren.modules.sys.service.ActivityService;


@Service("activityService")
public class ActivityServiceImpl extends ServiceImpl<ActivityDao, ActivityEntity> implements ActivityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ActivityEntity> page = this.page(
                new Query<ActivityEntity>().getPage(params),
                new QueryWrapper<ActivityEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insert(ActivityEntity activity) {
        baseMapper.insertActivity(activity);
    }


}
