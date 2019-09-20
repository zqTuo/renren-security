package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.entity.CodeEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 二维码管理
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:10:41
 */
@Mapper
public interface CodeDao extends BaseMapper<CodeEntity> {


    void insertCodeEntity(CodeEntity codeEntity);
}
