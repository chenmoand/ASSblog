package com.brageast.blog;

import com.brageast.blog.entity.Article;
import com.brageast.blog.mapper.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired(required = false)
    private ArticleMapper articleMapper;

    @Test
    public void contextLoads() {

    }

}
