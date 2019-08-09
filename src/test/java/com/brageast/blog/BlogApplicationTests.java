package com.brageast.blog;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.User;
import com.brageast.blog.mapper.GroupMapper;
import com.brageast.blog.mapper.PermissionsMapper;
import com.brageast.blog.service.ArticleService;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.EntityUtil;
import com.brageast.blog.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired(required=false)
    private GroupMapper groupMapper;
    @Autowired(required=false)
    private PermissionsMapper permissionsMapper;

    @Test
    public void contextLoads() throws Exception {
        /*new UserJwt();
        String str = PasswordTools.encrypt("adad");
        String strr = PasswordTools.decrypt(str);
        ConfigTools.decrypt(str);
        System.out.println(strr);
        userService.insertUser(10213,"chenmo","213213","2010557767@qq.com","admin","admin");
        userService.getUsers(new Page<>(0,4)).getRecords().forEach(System.out::println);*/

        User u = userService.findUser("阿三打撒");
        System.out.println(u);
//        userService.getUsers(new Page<>(1, 10)).getRecords().forEach(System.out::println);
        System.out.println("");
    }
    @Test
    public void Jsontest(){
        User admin = userService.findUser("chenmo");
        String token = JwtUtil.builder(admin);
        if(admin != null) {
            System.out.println(token);
        }
        Claims body = JwtUtil.getClaims(token);
        Map m = JSON.parseObject(JSON.toJSONString(body), Map.class);
        System.out.println(m);
    }

    @Test
    public void A(){
        userService.addUser("chenmo","132146","2010557767@qq.com",
                new HashSet<Integer>(){{add(1); add(2);}});
    }

    @Test
    public void B(){
        userService.deleteUser(4);
    }
    @Test
    public void C(){
//        groupMapper.getGroups(new Page<>(1, 5)).getRecords().forEach(System.out::println);
        System.out.println(groupMapper.findGroup(2));
    }
    @Test
    public void E(){

        permissionsMapper.addPermissions(EntityUtil.getEntity("abc","bcd"));
    }

    @Test
    public void H(){
//        permissionsMapper.deletePermissions(3);
        articleService.getBaseArticle(new Page<>(1,5))
        .getRecords().forEach(System.out::println);
    }
    @Test
    public void I(){
//        System.out.println(new ResultState(State.NODEFINED, "您无法访问这个API或者页面").toJsonString());

//        EntityUtil.println("str",new Date(), "15656", 454546);
        EntityUtil.log(log::info, 1+9,"demo", new Date());
    }
    @Test
    public void Z(){
        // 不知道这类怎吗玩所以我自己测试一下
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        String s = bpe.encode("demo");
        System.out.println(s);
        CharSequence c = "demo";
        System.out.println(bpe.matches("demo", s));


    }

}
