package com.brageast.blog;

import com.brageast.blog.entity.User;
import com.brageast.blog.service.ArticleService;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.JSONResult;
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
//        new UserJwt();
//        String str = PasswordTools.encrypt("adad");
//        String strr = PasswordTools.decrypt(str);
//        ConfigTools.decrypt(str);
//        System.out.println(strr);
//        userService.insertUser(10213,"chenmo","213213","2010557767@qq.com","admin","admin");
//        userService.getUsers(new Page<>(0,4)).getRecords().forEach(System.out::println);
        User user = userService.findUser("chenmo");
        if(user!=null) {
            System.out.println(user);
        } else {
            System.out.println("err");
        }
    }
    @Test
    public void Jsontest(){
        String str = JSONResult.fillResultString(1,"test","msssss");
        System.out.println(str);
    }


}
