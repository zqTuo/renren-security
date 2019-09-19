package io.renren.service.impl;

import io.renren.common.PageUtils;
import io.renren.common.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.renren.dao.BonusLogDao;
import io.renren.entity.BonusLogEntity;
import io.renren.service.BonusLogService;


@Service("bonusLogService")
public class BonusLogServiceImpl extends ServiceImpl<BonusLogDao, BonusLogEntity> implements BonusLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BonusLogEntity> page = this.page(
                new Query<BonusLogEntity>().getPage(params),
                new QueryWrapper<BonusLogEntity>()
        );

        return new PageUtils(page);
    }





}
