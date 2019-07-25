package com.brageast.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brageast.blog.entity.Article;
import com.brageast.blog.entity.BaseArticle;
import com.brageast.blog.mapper.ArticleMapper;
import com.brageast.blog.service.ArticeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class ArticeServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticeService {


    @Override
    public Article getMoreArticle(String url) {
        return baseMapper.getMoreArticle(url);
    }

    @Override
    public Page<BaseArticle> getBaseArticle(Page<BaseArticle> page) {
        return baseMapper.getBaseArticle(page);
    }

    @Override
    public void addArtice(Long id, String articleName, String describe,
                          String author, String lable, String classification,
                          String content, Date date, String url) {
        baseMapper.addArtice(id, articleName, describe, author, lable, classification, content,  date, url);
    }

    @Override
    public void updateArtice(Long id, String articleName, String describe, String author, String lable, String classification, String content, Date date, String url) {
        baseMapper.updateArtice(id, articleName, describe, author, lable, classification, content,  date, url);
    }


}
