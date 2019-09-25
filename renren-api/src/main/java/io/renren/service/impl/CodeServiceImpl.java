package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.Query;
import io.renren.dao.CodeDao;
import io.renren.entity.CodeEntity;

import io.renren.service.CodeService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("codeService")
public class CodeServiceImpl extends ServiceImpl<CodeDao, CodeEntity> implements CodeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CodeEntity> page = this.page(
                new Query<CodeEntity>().getPage(params),
                new QueryWrapper<CodeEntity>()
        );

        return new PageUtils(page);
    }




}
