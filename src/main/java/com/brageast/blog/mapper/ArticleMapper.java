package com.brageast.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.Article;
import com.brageast.blog.entity.BaseArticle;
import com.brageast.blog.util.entity.Combination;

import java.util.Date;
import java.util.Set;

public interface ArticleMapper extends BaseMapper<Article> {
    Article getMoreArticle(String url);
    Page<BaseArticle> getBaseArticle(Page<BaseArticle> page);
    void addArtice(Long id, String articleName, String describe,
                   String author, String lable, String classification,
                   String content, Date date, String url);
    void updateArtice(Long id, String articleName, String describe,
                      String author, String lable, String classification,
                      String content, Date date, String url);
    void deleteArtice(Long id);
    Combination<Integer, Integer> getArticeInfo();
    Set<Combination<String, String>> getLatestArtice();
    Set<String> getLables();
}
