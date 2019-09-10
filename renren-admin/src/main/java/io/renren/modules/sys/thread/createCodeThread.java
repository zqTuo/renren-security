package io.renren.modules.sys.thread;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.IdWorker;
import io.renren.common.utils.QRCodeUtil;
import io.renren.common.utils.ZipUtil;
import io.renren.modules.sys.dao.CodeDao;
import io.renren.modules.sys.entity.CodeEntity;
import io.renren.modules.sys.entity.OrderEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipOutputStream;

@Component
public class createCodeThread {
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private CodeDao codeDao;
    @Async
    public void  handleCode(CodeEntity codeEntity){
        try {
            System.out.println("模拟处理订单开始========"+Thread.currentThread().getName());
            String codeId = codeEntity.getQrcodeId();
            codeDao.insertCodeEntity(codeEntity);
            System.out.println("qrcodeId::"+codeId);
            String text ="www.baidu.com?"+codeId;

            QRCodeUtil.encode(text, "C:\\Users\\XKY\\Pictures\\Screenshots\\qq.png", "D:\\aaa", true, codeId+"",0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createZip(OrderEntity orderEntity) {
        try {

            java.lang.Thread.sleep(3000);
            String orderId = orderEntity.getOrderId();
            QueryWrapper<CodeEntity> wrapper = new QueryWrapper<>();
            HashMap<String, Object> map = new HashMap<>();
            map.put("order_id",orderId);
            wrapper.allEq(map);
            List<CodeEntity> list = codeDao.selectList(wrapper);

            List<String> urlListAll = new ArrayList<String>();
            //将文件从https上下载进服务器的目录，用files装好
            for (CodeEntity entity : list) {
                String codeId = entity.getQrcodeId();
                urlListAll.add("D:\\aaa\\" + codeId + ".jpg");
            }


            List<File> files = new ArrayList<>();
            for (String url : urlListAll) {
                System.out.println(url);
                File f = new File(url);
                if (!f.exists()) {
                    try {
                        f.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                files.add(f);
            }

            String s = "D:\\aaa\\11.zip";
            File file = new File(s);
            FileOutputStream outputStream = new FileOutputStream(file);
            ZipOutputStream toClient = new ZipOutputStream(outputStream);
//        将file打包成zp文件
            ZipUtil.zipFile(files, toClient);
            toClient.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
