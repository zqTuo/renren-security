package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.OrderDescDao;
import io.renren.modules.sys.entity.OrderDescEntity;
import io.renren.modules.sys.service.OrderDescService;


@Service("orderDescService")
public class OrderDescServiceImpl extends ServiceImpl<OrderDescDao, OrderDescEntity> implements OrderDescService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderDescEntity> page = this.page(
                new Query<OrderDescEntity>().getPage(params),
                new QueryWrapper<OrderDescEntity>()
        );

        return new PageUtils(page);
    }

}
