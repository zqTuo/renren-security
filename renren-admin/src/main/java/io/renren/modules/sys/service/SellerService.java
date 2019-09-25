package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.dto.SellerDto;
import io.renren.modules.sys.entity.SellerEntity;

import java.util.List;
import java.util.Map;

/**
 * 商家
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:19:22
 */
public interface SellerService extends IService<SellerEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SellerDto> getBusinessReport();


    void insert(SellerEntity entity);
}

