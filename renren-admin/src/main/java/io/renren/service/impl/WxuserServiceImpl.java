package io.renren.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.PageUtils;
import io.renren.common.Query;

import io.renren.modules.sys.dao.WxuserDao;
import io.renren.modules.sys.entity.WxuserEntity;
import io.renren.modules.sys.service.WxuserService;


@Service("wxuserService")
public class WxuserServiceImpl extends ServiceImpl<WxuserDao, WxuserEntity> implements WxuserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String userName = (String)params.get("name");
        IPage<WxuserEntity> page = this.page(
                new Query<WxuserEntity>().getPage(params),
                new QueryWrapper<WxuserEntity>()
                        .like(StringUtils.isNotBlank(userName),"user_name", userName)
        );

        return new PageUtils(page);
    }

}
