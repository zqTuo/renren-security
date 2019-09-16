package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.entity.MoneyEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 押金
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-10 16:23:30
 */
@Mapper
public interface MoneyDao extends BaseMapper<MoneyEntity> {


     boolean insertMoney(MoneyEntity entity);


}
