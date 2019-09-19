package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.PageUtils;
import io.renren.entity.BonusEntity;

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
}

