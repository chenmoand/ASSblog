package com.brageast.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@TableName("articlelist")
public class Article {
    private Long id;
    private String articleName;
    private String describe;
    private String author;
    private String lable;
    private String classification;
    private String content;
    private Date date;
    private String url;

}
