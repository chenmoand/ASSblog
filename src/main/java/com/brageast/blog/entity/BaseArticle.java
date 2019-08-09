package com.brageast.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//@AllArgsConstructor
@TableName("articlelist")
public class BaseArticle {
    private String articleName;
    private String describe;
    private String url;
}
