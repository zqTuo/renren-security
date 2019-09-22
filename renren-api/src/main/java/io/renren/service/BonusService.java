package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.PageUtils;
import io.renren.entity.BonusEntity;
import io.renren.entity.CodeEntity;

import java.util.List;
import java.util.Map;

/**
 * 奖金池
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-19 11:03:50
 */
public interface BonusService extends IService<BonusEntity> {

    PageUtils queryPage(Map<String, Object> params);

    BonusEntity BigGame(List<BonusEntity> bonusEntityList, Long userId, CodeEntity activityName);
}

