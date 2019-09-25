package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.Query;

import io.renren.modules.sys.dao.MoneyDao;
import io.renren.modules.sys.entity.MoneyEntity;
import io.renren.modules.sys.service.MoneyService;


@Service("moneyService")
public class MoneyServiceImpl extends ServiceImpl<MoneyDao, MoneyEntity> implements MoneyService {

    @Autowired
    private MoneyDao moneyDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MoneyEntity> page = this.page(
                new Query<MoneyEntity>().getPage(params),
                new QueryWrapper<MoneyEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public boolean save(MoneyEntity entity) {
        return moneyDao.insertMoney(entity);
    }
}
