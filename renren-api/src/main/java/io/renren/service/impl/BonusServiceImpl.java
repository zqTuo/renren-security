package io.renren.service.impl;

import io.renren.common.PageUtils;
import io.renren.common.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.renren.dao.BonusDao;
import io.renren.entity.BonusEntity;
import io.renren.service.BonusService;


@Service("bonusService")
public class BonusServiceImpl extends ServiceImpl<BonusDao, BonusEntity> implements BonusService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BonusEntity> page = this.page(
                new Query<BonusEntity>().getPage(params),
                new QueryWrapper<BonusEntity>()
        );

        return new PageUtils(page);
    }

}
