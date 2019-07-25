package com.brageast.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brageast.blog.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface ArticeService extends IService<Article> {

    Article getMoreArticle(String url);
    IPage<Article> getBaseArticle(Page<Article> page);
    void addArtice(@Param("id") Long id, @Param("articleName") String articleName,
                   @Param("describe") String describe, @Param("author") String author,
                   @Param("lable") String lable, @Param("classification") String classification,
                   @Param("content") String content, @Param("date") Date date, @Param("url") String url);
}
