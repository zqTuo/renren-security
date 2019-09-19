package io.renren.common.utils;

import io.renren.entity.BonusEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryUtil {
    /**
     * 抽奖
     *
     * @param orignalRates 原始的概率列表，保证顺序和实际物品对应
     * @return 物品的索引
     */
    public static int lottery(List<Double> orignalRates) {
        if (orignalRates == null || orignalRates.isEmpty()) {
            return -1;
        }

        int size = orignalRates.size();

        // 计算总概率，这样可以保证不一定总概率是1
        double sumRate = 0;
        for (Double rate : orignalRates) {
            sumRate += rate;
        }

        // 计算每个物品在总概率的基础下的概率情况
        List<Double> sortOrignalRates = new ArrayList<Double>(size);
        Double tempSumRate = 0d;
        for (double rate : orignalRates) {
            tempSumRate+= rate;
            sortOrignalRates.add(tempSumRate / sumRate);
        }

        // 根据区块值来获取抽取到的物品索引
        double nextDouble = Math.random(); //总概率区块内生成一个随机数

        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);


        return sortOrignalRates.indexOf(nextDouble);
    }

    public static int getJD(List<Double> orignalRates) {
        if (orignalRates == null || orignalRates.isEmpty()) {
            return -1;
        }

        int size = orignalRates.size();

        // 计算总概率，这样可以保证不一定总概率是1
        double sumRate = 0d;
        for (double rate : orignalRates) {
            sumRate += rate;
        }

        // 计算每个物品在总概率的基础下的概率情况
        List<Double> sortOrignalRates = new ArrayList<Double>(size);
        Double tempSumRate = 0d;
        for (double rate : orignalRates) {
            tempSumRate += rate;
            sortOrignalRates.add(tempSumRate / sumRate);
        }

        // 根据区块值来获取抽取到的物品索引
        double nextDouble = Math.random() * sumRate;
        sortOrignalRates.add(nextDouble);
        Collections.sort(sortOrignalRates);

        return sortOrignalRates.indexOf(nextDouble);
    }

    public static void main(String[] args) {
        List<BonusEntity> bonusEntityList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BonusEntity bonusEntity = new BonusEntity();
            bonusEntity.setBonusId(Long.valueOf((i+1)));
            bonusEntity.setBonusName("奖品" + (i+1));
            bonusEntity.setBonusGailv(String.valueOf(20 * i));
            bonusEntityList.add(bonusEntity);
        }

        List<Double> orignalRates = new ArrayList<>();

        for(BonusEntity bonusEntity:bonusEntityList){
            orignalRates.add(Double.valueOf(bonusEntity.getBonusGailv()));
        }




        for (int i = 0; i < 5; i++) {
            //从中抽取 获取奖品索引
            int orignalIndex = LotteryUtil.lottery(orignalRates); //抽到的奖品索引

            if(orignalIndex < 0){
                System.out.println("抽取异常：" + orignalIndex);
                break;
            }

            BonusEntity bonusEntity = bonusEntityList.get(orignalIndex);
            System.out.println("抽取奖品：" + bonusEntity.toString());


        }


    }

}

