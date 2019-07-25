package com.brageast.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.Article;

import java.util.Date;

public interface ArticleMapper extends BaseMapper<Article> {
    Article getMoreArticle(String url);
    IPage<Article> getBaseArticle(Page page);
    void addArtice(Long id, String articleName, String describe,
                   String author, String lable, String classification,
                   String content, Date date, String url);

}
