package io.renren.service.impl;

import io.renren.common.IdWorker;
import io.renren.common.PageUtils;
import io.renren.common.Query;
import io.renren.common.utils.LotteryUtil;
import io.renren.dao.BonusLogDao;
import io.renren.entity.BonusLogEntity;
import io.renren.entity.CodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.renren.dao.BonusDao;
import io.renren.entity.BonusEntity;
import io.renren.service.BonusService;

import javax.xml.crypto.Data;


@Service("bonusService")
public class BonusServiceImpl extends ServiceImpl<BonusDao, BonusEntity> implements BonusService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private BonusLogDao bonusLogDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BonusEntity> page = this.page(
                new Query<BonusEntity>().getPage(params),
                new QueryWrapper<BonusEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public BonusEntity BigGame(List<BonusEntity> bonusEntityList, Long userId, CodeEntity codeEntity) {

//        循环获得每一个奖品的概率
        List<Double> orignalRates = new ArrayList<>();
        for (BonusEntity bonusEntity : bonusEntityList) {
            orignalRates.add(Double.valueOf(bonusEntity.getBonusGailv()));
        }

        int lotteryIndex = LotteryUtil.lottery(orignalRates);
        if (lotteryIndex < 0) {
            throw new RuntimeException("抽取异常:" + lotteryIndex);
        }
//        更新数量并减一
        BonusEntity bonusEntity = bonusEntityList.get(lotteryIndex);
        bonusEntity.setCurrentNum(bonusEntity.getCurrentNum()-1);
        baseMapper.updateById(bonusEntity);

//        向日记表里面插入一条数据
        BonusLogEntity bonusLogEntity = new BonusLogEntity();
//        唯一id
        bonusLogEntity.setBlId(idWorker.nextId());
//        二维码编号
        bonusLogEntity.setQrCode(codeEntity.getQrcodeId());
//        奖品id
        bonusLogEntity.setBonusId(String.valueOf(bonusEntity.getBonusId()));
//        奖品名字
        bonusLogEntity.setBonusName(bonusLogEntity.getBonusName());
//        活动名字
        bonusLogEntity.setActitityName(codeEntity.getActivityName());
//        创建时间
        bonusLogEntity.setCreateTime(new Date());
        bonusLogDao.addBonusLogEntity(bonusLogEntity);

        return bonusEntity;

    }
}
