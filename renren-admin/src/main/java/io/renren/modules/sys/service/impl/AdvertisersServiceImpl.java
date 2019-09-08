package io.renren.modules.sys.service.impl;

import io.renren.common.utils.IdWorker;
import io.renren.modules.sys.dao.*;
import io.renren.modules.sys.entity.*;
import io.renren.modules.sys.thread.createCodeThread;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.service.AdvertisersService;


@Service("advertisersService")
public class AdvertisersServiceImpl extends ServiceImpl<AdvertisersDao, AdvertisersEntity> implements AdvertisersService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDescDao orderDescDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    createCodeThread codeThread;
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private SellerDao sellerDao;

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
    public  void createQrCode(Order order) {


        OrderEntity orderEntity = order.getOrderEntity();
        long id = idWorker.nextId();
//        向订单表里面插入一条数据
        orderEntity.setOrderId(id);
        orderEntity.setCreateTime(new Date());
        orderEntity.setAdvertisersId("0");
        orderDao.insertOrderEntity(orderEntity);

//       向订单详情表里面插入一条数据
        List<OrderDescEntity> orderDescEntity = order.getOrderDescEntity();
        for (OrderDescEntity descEntity : orderDescEntity) {
            long id2 = idWorker.nextId();
            descEntity.setId(id2);
            descEntity.setOrderId(orderEntity.getOrderId());

//            通过商家名字查询对应的商家id
            String sellerName = descEntity.getSellerName();

            HashMap<String, Object> map = new HashMap<>();
            map.put("nick_name",sellerName);
            QueryWrapper<SellerEntity> wrapper = new QueryWrapper<>();

            wrapper.allEq(map);
            SellerEntity sellerEntity = sellerDao.selectOne(wrapper);

//            设置商家id
            Long sellerId = sellerEntity.getSellerId();
            descEntity.setSellerId(sellerId);
            orderDescDao.insertOrderDescEntity(descEntity);
            ActivityEntity activityEntity = activityDao.selectById(descEntity.getActivityId());
//            利用多线程生成二维码表

            Long num = descEntity.getNum();
            for (int i = 0; i < num; i++) {
//                设置二维码表
                CodeEntity codeEntity = new CodeEntity();
                codeEntity.setQrcodeId(String.valueOf(idWorker.nextId()));
                codeEntity.setAdvertisersId(orderEntity.getAdvertisersId());
                codeEntity.setSellerId(String.valueOf(descEntity.getSellerId()));
                codeEntity.setActivityId(String.valueOf(descEntity.getActivityId()));
                codeEntity.setOrderId(descEntity.getOrderId());
                codeEntity.setOrderdescId(descEntity.getId());
                codeEntity.setIsFocus(activityEntity.getIsFocus());
                codeEntity.setIsQr(activityEntity.getIsQr());
                codeEntity.setSellerName(descEntity.getSellerName());
                codeEntity.setAdvertisersName("人人开源有限公司");
                codeEntity.setActivityName(activityEntity.getActivityName());



                codeThread.handleCode(codeEntity);
            }

        }

        codeThread.createZip(orderEntity);
    }

}
