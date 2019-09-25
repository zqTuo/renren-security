package io.renren.service.impl;

import io.renren.common.utils.PageUtils;
import io.renren.common.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import io.renren.modules.sys.dao.QudaouserDao;
import io.renren.modules.sys.entity.QudaouserEntity;
import io.renren.modules.sys.service.QudaouserService;


@Service("qudaouserService")
public class QudaouserServiceImpl extends ServiceImpl<QudaouserDao, QudaouserEntity> implements QudaouserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QudaouserEntity> page = this.page(
                new Query<QudaouserEntity>().getPage(params),
                new QueryWrapper<QudaouserEntity>()
        );

        return new PageUtils(page);
    }

}
