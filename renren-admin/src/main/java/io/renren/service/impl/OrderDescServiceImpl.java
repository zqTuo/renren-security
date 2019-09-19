package io.renren.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.PageUtils;
import io.renren.common.Query;

import io.renren.modules.sys.dao.OrderDescDao;
import io.renren.modules.sys.entity.OrderDescEntity;
import io.renren.modules.sys.service.OrderDescService;


@Service("orderDescService")
public class OrderDescServiceImpl extends ServiceImpl<OrderDescDao, OrderDescEntity> implements OrderDescService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String) params.get("name");
        IPage<OrderDescEntity> page = this.page(
                new Query<OrderDescEntity>().getPage(params),
                new QueryWrapper<OrderDescEntity>()
                        .like(StringUtils.isNotBlank(name),"order_id", name)
        );

        return new PageUtils(page);
    }

    @Override
    public List<OrderDescEntity> findAllByOrderId(String orderId) {
        QueryWrapper<OrderDescEntity> wrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("order_id",orderId);
        wrapper.allEq(map);
        List<OrderDescEntity> list = baseMapper.selectList(wrapper);
        return list;
    }

}
