package com.brageast.blog;

import com.alibaba.druid.filter.config.ConfigTools;
import com.brageast.blog.mapper.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired(required = false)
    private ArticleMapper articleMapper;

    @Test
    public void contextLoads() throws Exception {
        String pwd = ConfigTools.encrypt("200075xzh");
        String p = ConfigTools.decrypt(pwd);
        System.out.println(pwd+"\n"+p);
    }

}
