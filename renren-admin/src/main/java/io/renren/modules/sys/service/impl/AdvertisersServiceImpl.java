package io.renren.modules.sys.service.impl;

import io.renren.common.utils.IdWorker;
import io.renren.modules.sys.dao.OrderDao;
import io.renren.modules.sys.dao.OrderDescDao;
import io.renren.modules.sys.entity.CodeEntity;
import io.renren.modules.sys.entity.OrderDescEntity;
import io.renren.modules.sys.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.dao.AdvertisersDao;
import io.renren.modules.sys.entity.AdvertisersEntity;
import io.renren.modules.sys.service.AdvertisersService;


@Service("advertisersService")
public class AdvertisersServiceImpl extends ServiceImpl<AdvertisersDao, AdvertisersEntity> implements AdvertisersService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDescDao orderDescDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdvertisersEntity> page = this.page(
                new Query<AdvertisersEntity>().getPage(params),
                new QueryWrapper<AdvertisersEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insert(AdvertisersEntity entity) {
        baseMapper.insertAdvertisersEntity(entity);
    }

    @Override
    public void createQrCode(OrderEntity orderEntity) {


        IdWorker idWorker = new IdWorker();
        long id = idWorker.nextId();
//        向订单表里面插入一条数据
        orderEntity.setCreateTime(new Date());
        orderEntity.setAdvertisersId("0");
        orderDao.insertOrderEntity(orderEntity);

//       向订单详情表里面插入一条数据

        List<OrderDescEntity> orderDescEntity = orderEntity.getOrderDescEntity();
        for (OrderDescEntity descEntity : orderDescEntity) {
            IdWorker idWorker2 =new IdWorker();
            long id2 = idWorker.nextId();
            descEntity.setId(id2);
            descEntity.setOrderId(id);
            orderDescDao.insertOrderDescEntity(descEntity);
        }
    }
}
