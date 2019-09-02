package io.renren.modules.sys.service.impl;

import io.renren.common.utils.IdWorker;
import io.renren.common.utils.ZipUtil;
import io.renren.modules.sys.dao.*;
import io.renren.modules.sys.entity.*;
import io.renren.modules.sys.thread.createCodeThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.sys.service.AdvertisersService;


@Service("advertisersService")
public class AdvertisersServiceImpl extends ServiceImpl<AdvertisersDao, AdvertisersEntity> implements AdvertisersService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDescDao orderDescDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    createCodeThread codeThread;
    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private CodeDao codeDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdvertisersEntity> page = this.page(
                new Query<AdvertisersEntity>().getPage(params),
                new QueryWrapper<AdvertisersEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void insert(AdvertisersEntity entity) {
        baseMapper.insertAdvertisersEntity(entity);
    }

    @Override
    public void createQrCode(Order order) {


        OrderEntity orderEntity = order.getOrderEntity();
        long id = idWorker.nextId();
//        向订单表里面插入一条数据
        orderEntity.setOrderId(id);
        orderEntity.setCreateTime(new Date());
        orderEntity.setAdvertisersId("0");
        orderDao.insertOrderEntity(orderEntity);

//       向订单详情表里面插入一条数据
        List<OrderDescEntity> orderDescEntity = order.getOrderDescEntity();
        for (OrderDescEntity descEntity : orderDescEntity) {
            long id2 = idWorker.nextId();
            descEntity.setId(id2);
            descEntity.setOrderId(orderEntity.getOrderId());
            orderDescDao.insertOrderDescEntity(descEntity);

//            获取活动表里面的数据
            ActivityEntity activityEntity = activityDao.selectById(descEntity.getId());
//            利用多线程生成二维码表

            Long num = descEntity.getNum();
            for (int i = 0; i < num; i++) {
                CodeEntity codeEntity = new CodeEntity();
                codeEntity.setCodeId(idWorker.nextId());
                codeEntity.setActivityId(orderEntity.getAdvertisersId());
                codeEntity.setSellerId(orderEntity.getSellerId());
                codeEntity.setActivityId(descEntity.getActivityId()+"");
                codeEntity.setIsFocus("0");
                codeEntity.setIsQr("0");

                codeThread.handleCode(codeEntity);
            }

            try {
                CodeEntity codeEntity = new CodeEntity();
                codeEntity.setSellerId(orderEntity.getSellerId());
                List<CodeEntity> list = codeDao.selectList(new QueryWrapper<>());
                List<String> urlListAll = new ArrayList<String>();
                //将文件从https上下载进服务器的目录，用files装好
                for (CodeEntity entity : list) {
                    Long codeId = entity.getCodeId();
                    urlListAll.add("D:\\aaa\\123.zip"+codeId);
                }

                ArrayList<File> files = new ArrayList<>();
                for (String s : urlListAll) {
                    File f = new File(s);
                    if(!f.exists()){
                        try {
                            f.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    files.add(f);
                }


                String s = "D:\\aaa\\"+orderEntity.getSellerId()+".zip";
                File file = new File(s);
                FileOutputStream outputStream = new FileOutputStream(file);
                ZipOutputStream toClient = new ZipOutputStream(outputStream);
//        将file打包成zp文件
                ZipUtil.zipFile(files,toClient );
                toClient.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
