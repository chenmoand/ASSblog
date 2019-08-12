package com.brageast.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brageast.blog.entity.Article;
import com.brageast.blog.entity.BaseArticle;
import com.brageast.blog.util.entity.Combination;
import com.brageast.blog.util.entity.ResultState;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface ArticleService extends IService<Article> {

    Article getMoreArticle(@Param("url") String url);
    Page<BaseArticle> getBaseArticle(Page<BaseArticle> page);
    void addArtice(@Param("id") Long id, @Param("articleName") String articleName,
                   @Param("describe") String describe, @Param("author") String author,
                   @Param("lable") String lable, @Param("classification") String classification,
                   @Param("content") String content, @Param("date") Date date, @Param("url") String url);
    void updateArtice(@Param("id") Long id, @Param("articleName") String articleName,
                      @Param("describe") String describe, @Param("author") String author,
                      @Param("lable") String lable, @Param("classification") String classification,
                      @Param("content") String content, @Param("date") Date date, @Param("url") String url);
    void deleteArtice(@Param("id") Long id);
    Combination<Integer, Integer> getArticeInfo();
    ResultState getLatestArtice();
}
