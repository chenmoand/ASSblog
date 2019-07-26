package com.brageast.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.Article;
import com.brageast.blog.entity.BaseArticle;
import com.brageast.blog.service.ArticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/article")
public class AriticleController {

    @Autowired
    private ArticeService articeService;

    @RequestMapping(value = "/page")
    public List<BaseArticle> getBaseAriticles(Integer current, Long size){
        int ct = current == null? 0 : current;
        long sz = size == null? 10 : size;
        Page<BaseArticle> page = new Page<>(ct, sz);
        return articeService.getBaseArticle(page).getRecords();
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
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping(value = "/delete")
    public Boolean deleteArtice(Long id){
        try{
            articeService.deleteArtice(id);
            return true;
        } catch (Exception e){
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        }
    }
}
