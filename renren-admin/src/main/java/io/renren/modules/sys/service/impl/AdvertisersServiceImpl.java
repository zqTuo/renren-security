package io.renren.modules.sys.service.impl;

import io.renren.common.utils.IdWorker;
import io.renren.common.utils.ZipUtil;
import io.renren.modules.sys.dao.*;
import io.renren.modules.sys.entity.*;
import io.renren.modules.sys.thread.createCodeThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.zip.ZipOutputStream;

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
            String sellerId = sellerEntity.getSellerId();
            descEntity.setSellerId(Long.valueOf(sellerId));
            orderDescDao.insertOrderDescEntity(descEntity);

//            利用多线程生成二维码表

            Long num = descEntity.getNum();
            for (int i = 0; i < num; i++) {
                CodeEntity codeEntity = new CodeEntity();
                codeEntity.setCodeId(idWorker.nextId());
                codeEntity.setAdvertisersId(orderEntity.getAdvertisersId());
                codeEntity.setSellerId(descEntity.getSellerId()+"");
                codeEntity.setActivityId(descEntity.getActivityId()+"");
                codeEntity.setOrderId(descEntity.getOrderId());
                codeEntity.setOrderdescId(descEntity.getId());
                codeEntity.setIsFocus("0");
                codeEntity.setIsQr("0");

                codeThread.handleCode(codeEntity);
            }

        }

        codeThread.createZip(orderEntity);
    }

}
