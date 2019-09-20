package io.renren.service.impl;

import io.renren.common.PageUtils;
import io.renren.common.Query;
import io.renren.common.utils.LotteryUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.renren.dao.BonusDao;
import io.renren.entity.BonusEntity;
import io.renren.service.BonusService;


@Service("bonusService")
public class BonusServiceImpl extends ServiceImpl<BonusDao, BonusEntity> implements BonusService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BonusEntity> page = this.page(
                new Query<BonusEntity>().getPage(params),
                new QueryWrapper<BonusEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public BonusEntity BigGame(List<BonusEntity> bonusEntityList) {

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
        bonusEntity.setBonusNum(bonusEntity.getBonusNum()-1);
        baseMapper.updateById(bonusEntity);
        return bonusEntity;

    }
}
