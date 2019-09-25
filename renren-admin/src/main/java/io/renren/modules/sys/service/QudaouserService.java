package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;

import io.renren.modules.sys.entity.QudaouserEntity;

import java.util.Map;

/**
 * 渠道用户管理
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-18 17:33:31
 */
public interface QudaouserService extends IService<QudaouserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

