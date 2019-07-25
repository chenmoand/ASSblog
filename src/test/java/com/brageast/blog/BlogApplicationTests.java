package com.brageast.blog;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.BaseArticle;
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
    public void contextLoads() {

        System.out.println(articleMapper.getBaseArticle(new Page<BaseArticle>(1,5)));
//        .getRecords().forEach(System.out::println);

    }

}
