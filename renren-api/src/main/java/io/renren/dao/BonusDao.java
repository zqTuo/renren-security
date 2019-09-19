package io.renren.dao;

import io.renren.entity.BonusEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 奖金池
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-19 11:03:50
 */
@Mapper
public interface BonusDao extends BaseMapper<BonusEntity> {
	
}
