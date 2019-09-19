package io.renren.service.impl;



import io.renren.dao.SellerDao;
import io.renren.dto.SellerDto;
import io.renren.entity.SellerEntity;
import io.renren.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.PageUtils;
import io.renren.common.Query;



@Service("sellerService")
public class SellerServiceImpl extends ServiceImpl<SellerDao, SellerEntity> implements SellerService {



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SellerEntity> page = this.page(
                new Query<SellerEntity>().getPage(params),
                new QueryWrapper<SellerEntity>()
        );
        return new PageUtils(page);
    }


    @Override
    public List<SellerDto> getBusinessReport() {

        return baseMapper.select();
    }

    @Override
    public void insert(SellerEntity entity) {
        baseMapper.insertSellerEntity(entity);
    }


}
