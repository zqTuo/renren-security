package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.BonusEntity;
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

    void insertBonusEntity(BonusEntity bonusEntity);

}
