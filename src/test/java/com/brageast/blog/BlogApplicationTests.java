package com.brageast.blog;

import com.alibaba.druid.filter.config.ConfigTools;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.service.ArticleService;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.PasswordTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() throws Exception {
        String str = PasswordTools.encrypt("adad");
//        String strr = PasswordTools.decrypt(str);
//        ConfigTools.decrypt(str);
//        System.out.println(strr);
        userService.getUsers(new Page<>(0,4)).getRecords().forEach(System.out::println);
    }

}
