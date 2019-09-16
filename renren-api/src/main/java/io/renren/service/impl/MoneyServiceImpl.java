package io.renren.service.impl;


import io.renren.common.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.PageUtils;

import io.renren.common.utils.Constant;
import io.renren.dao.MoneyDao;
import io.renren.entity.MoneyEntity;
import io.renren.entity.OrderSalesEntity;
import io.renren.entity.SellerEntity;
import io.renren.entity.WxuserEntity;
import io.renren.service.MoneyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;


@Service("moneyService")
public class MoneyServiceImpl extends ServiceImpl<MoneyDao, MoneyEntity> implements MoneyService {
    private static Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
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
    public boolean insertMoney(MoneyEntity entity) {
        return moneyDao.insertMoney(entity);
    }

    @Override
    public void payFinished(MoneyEntity moneyEntity) {
        log.info("========== 订单号：" + moneyEntity.getMoneyId() + ",正在结算中===========");
        //更新订单状态
        /*order.setPayTime(new Date());*/
        moneyEntity.setPayStatus(Constant.ORDER_PAY_SUCCESS);
        baseMapper.updateById(moneyEntity);

        /*if(moneyEntity.getMoneyYajin().compareTo(new BigDecimal("0")) > 0){
            //生成流水
           *//* MoneyEntity sellerEntity = MoneyEntity.builder().sellerId(moneyEntity.getSellerId())
                    .moneyId(moneyEntity.getMoneyId()).moneyYajin(moneyEntity.getMoneyYajin())
                    .createTime(new Date()).build();*//*
           moneyEntity.setPayStatus("2");
           moneyEntity.setMoneyPay("1");
           moneyEntity.setCreateTime(new Date());

            moneyDao.insert(moneyEntity);
            log.info("订单流水生成成功");
        }*/

      /*  WxuserEntity user = wxuserDao.selectById(order.getUserId());

        if(order.getOrderSourceType() == Constant.ORDER_TYPE_CAKE){ // 购买蛋糕
            //通知用户预订成功

        }else if(order.getOrderSourceType() == Constant.ORDER_TYPE_COURSE){ // 预约烘焙课程

        }else { // 购买会员

        }*/
    }
}
