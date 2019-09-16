package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.dto.SellerDto;
import io.renren.modules.sys.entity.SellerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商家
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:19:22
 */
@Mapper
public interface SellerDao extends BaseMapper<SellerEntity> {

    List<SellerDto> select();


    int insertSellerEntity(SellerEntity entity);
}
