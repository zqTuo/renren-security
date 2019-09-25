package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;

import io.renren.entity.BonusLogEntity;

import java.util.Map;

/**
 * 中奖记录
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-19 11:03:50
 */
public interface BonusLogService extends IService<BonusLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

