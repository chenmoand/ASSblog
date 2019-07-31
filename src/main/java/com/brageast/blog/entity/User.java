package com.brageast.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("Blog_User")
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String group;
    private String permissions;
}
