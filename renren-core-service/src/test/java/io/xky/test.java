package io.xky;


import com.xky.springbootmapper.mapper.TbActivityMapper;
import com.xky.springbootmapper.model.TbActivity;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Reference;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = test.class)
@MapperScan("com.xky.springbootmapper")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class test {

    @Reference
    private TbActivityMapper activityMapper;

    @Test
   public void test(){
        List<TbActivity> all = activityMapper.selectAll();
       for (TbActivity tbActivity : all) {
           System.out.println(tbActivity);
       }
   }
}
