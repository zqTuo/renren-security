package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.PageUtils;
import io.renren.common.Query;

import io.renren.modules.sys.dao.CodeDao;
import io.renren.modules.sys.entity.CodeEntity;
import io.renren.modules.sys.service.CodeService;


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
