package io.renren.service.impl;

import io.renren.common.utils.IdWorker;
import io.renren.modules.sys.dao.*;
import io.renren.modules.sys.entity.*;
import io.renren.modules.sys.thread.createCodeThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.Query;

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
    public void createQrCode(Order order) {


        OrderEntity orderEntity = order.getOrderEntity();
        long id = idWorker.nextId();
//        向订单表里面插入一条数据
        orderEntity.setOrderId(String.valueOf(id));
        orderEntity.setCreateTime(new Date());
        orderEntity.setAdvertisersId("0");
        orderDao.insertOrderEntity(orderEntity);

//       向订单详情表里面插入一条数据
        List<OrderDescEntity> orderDescEntity = order.getOrderDescEntity();

        String sellerNum = String.valueOf(order.getNum());//获取商家数量
        int Num = 0;
        if ("0".equals(sellerNum) || null==sellerNum) {

            Num=1;

        }
        for (int j = 0; j < Num; j++) {
            for (OrderDescEntity descEntity : orderDescEntity) {
                descEntity.setId(String.valueOf(idWorker.nextId()));
                descEntity.setOrderId(orderEntity.getOrderId());

//            通过商家名字查询对应的商家id
                String sellerName = descEntity.getSellerName();
                SellerEntity sellerEntity = sellerDao.selectOne(new QueryWrapper<SellerEntity>().eq("nick_name", sellerName));

//            设置商家id
                String sellerId = sellerEntity.getSellerId();
                descEntity.setSellerId(String.valueOf(sellerId));
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
                    codeEntity.setOrderId(Long.valueOf(descEntity.getOrderId()));
                    codeEntity.setOrderdescId(Long.valueOf(descEntity.getId()));
                    codeEntity.setIsFocus(activityEntity.getIsFocus());

                    codeEntity.setSellerName(descEntity.getSellerName());
                    codeEntity.setAdvertisersName("炫酷游互娱有限公司");
                    codeEntity.setActivityName(activityEntity.getActivityName());
                    codeEntity.setActivityUrl("http://pip.maojimall.com/v1/?r=" + codeEntity.getQrcodeId());


                    codeThread.handleCode(codeEntity);
                }

            }
        }

        codeThread.createZip(orderEntity);
    }

}
