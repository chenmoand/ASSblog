package com.brageast.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.Article;
import com.brageast.blog.entity.BaseArticle;
import com.brageast.blog.service.ArticleService;
import com.brageast.blog.util.EntityUtil;
import com.brageast.blog.util.entity.Combination;
import com.brageast.blog.util.entity.ResultState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/api/article")
public class AriticleController {

    @Autowired
    private ArticleService articeService;

    @RequestMapping(value = "/page")
    public Combination<List<BaseArticle>, Long> getBaseAriticles(Integer current, Long size){
        int ct = current == null? 0 : current;
        long sz = size == null? 10 : size;
        Page<BaseArticle> page = new Page<>(ct, sz);
        Page<BaseArticle> pb = articeService.getBaseArticle(page);
        return EntityUtil.getEntity(pb.getRecords(), pb.getPages());
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean updateArtice(@RequestBody Article article){
        try{
            articeService.updateArtice(
                    article.getId(), article.getArticleName(),
                    article.getDescribe(), article.getAuthor(),
                    article.getLable(), article.getClassification(),
                    article.getContent(), article.getDate(),
                    article.getUrl()
            );
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
    }
    @RequestMapping(value = "/delete")
    public Boolean deleteArtice(Long id){
        try{
            articeService.deleteArtice(id);
            return true;
        } catch (Exception e){
//            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
    }
    @RequestMapping(value = "/articles")
    public Article getMoreAriticle(String url){
        return articeService.getMoreArticle(url);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Boolean addAriticle(@RequestBody Article article){
        try {
            articeService.addArtice(
                    article.getId(), article.getArticleName(),
                    article.getDescribe(), article.getAuthor(),
                    article.getLable(), article.getClassification(),
                    article.getContent(), article.getDate(),
                    article.getUrl()
            );
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
    }
    @RequestMapping(value = "/f")
    public Article findAriticle(String url) {
        return articeService.getMoreArticle(url);
    }

    @RequestMapping(value = "/wz")
    public Combination<Integer, Integer> getArticeInfo() {
//        System.out.println(articeService.getArticeInfo().toJsonString());
        return articeService.getArticeInfo();
    }
    @RequestMapping(value = "/latest")
    public ResultState getLatestArtice() {
        return articeService.getLatestArtice();
    }
    @RequestMapping(value = "/lables")
    public Set<String> getLables() {
        return articeService.getLables();
    }
}
