package io.renren.service;

import io.renren.modules.sys.entity.CodeEntity;
import io.renren.modules.sys.thread.createCodeThread;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

public class test {

   /* @Autowired
    private createCodeThread codeThread;*/


    @Test
    public void test() {
        createCodeThread codeThread = new createCodeThread();
        for (int i = 0; i < 10; i++) {

            CodeEntity codeEntity = new CodeEntity();
            codeEntity.setCodeId((long) i);
            codeThread.handleCode(codeEntity);
        }
    }

}
