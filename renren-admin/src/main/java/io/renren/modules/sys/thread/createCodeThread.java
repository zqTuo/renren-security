package io.renren.modules.sys.thread;

import io.renren.common.utils.IdWorker;
import io.renren.common.utils.QRCodeUtil;
import io.renren.modules.sys.dao.CodeDao;
import io.renren.modules.sys.entity.CodeEntity;
import io.renren.modules.sys.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class createCodeThread {
    @Autowired
    private IdWorker idWorker;

    @Autowired
    private CodeDao codeDao;
    @Async(value = "threadPoolTaskExecutor")
    public void  handleCode(CodeEntity codeEntity){
        try {
            codeDao.insertCodeEntity(codeEntity);
            Long codeId = codeEntity.getCodeId();
            String text ="www.baidu.com?"+codeId;

            QRCodeUtil.encode(text, "C:\\Users\\XKY\\Pictures\\Screenshots\\qq.png", "D:\\aaa", true, codeId+"",0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
