package com.brageast.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.Article;
import com.brageast.blog.entity.BaseArticle;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface ArticleMapper extends BaseMapper<Article> {
    Article getMoreArticle(String url);
    Page<BaseArticle> getBaseArticle(Page<BaseArticle> page);
    void addArtice(Long id, String articleName, String describe,
                   String author, String lable, String classification,
                   String content, Date date, String url);
    void updateArtice(@Param("id") Long id, @Param("articleName") String articleName,
                      @Param("describe") String describe, @Param("author") String author,
                      @Param("lable") String lable, @Param("classification") String classification,
                      @Param("content") String content, @Param("date") Date date, @Param("url") String url);
}
