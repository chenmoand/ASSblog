package com.brageast.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brageast.blog.entity.Article;
import com.brageast.blog.entity.BaseArticle;
import com.brageast.blog.mapper.ArticleMapper;
import com.brageast.blog.service.ArticleService;
import com.brageast.blog.util.entity.Combination;
import com.brageast.blog.util.entity.ResultState;
import com.brageast.blog.util.entity.State;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {


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

    @Override
    public void deleteArtice(Long id) {
        baseMapper.deleteArtice(id);
    }

    @Override
    public Combination<Integer, Integer> getArticeInfo() {
        return baseMapper.getArticeInfo();
    }

    @Override
    public ResultState getLatestArtice() {
        Set<Combination<String, String>> sc;
        try {
            sc = baseMapper.getLatestArtice();
        } catch (Exception e){
            log.error(e.getMessage());
            return new ResultState(State.FAIL, "发生了错误");
        }
        return new ResultState(State.SUCCESS,"获取成功", sc);
    }

    @Override
    public Set<String> getLables() {
        return baseMapper.getLables();
    }


}
