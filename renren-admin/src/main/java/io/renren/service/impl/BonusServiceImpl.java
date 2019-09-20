package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.PageUtils;
import io.renren.common.Query;

import io.renren.modules.sys.dao.BonusDao;
import io.renren.modules.sys.entity.BonusEntity;
import io.renren.modules.sys.service.BonusService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
