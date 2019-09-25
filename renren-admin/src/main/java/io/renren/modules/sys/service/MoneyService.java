package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.MoneyEntity;

import java.util.Map;

/**
 * 押金
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-10 16:23:30
 */
public interface MoneyService extends IService<MoneyEntity> {

    PageUtils queryPage(Map<String, Object> params);


    boolean save(MoneyEntity entity);
}

