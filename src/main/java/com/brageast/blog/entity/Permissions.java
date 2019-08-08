package com.brageast.blog.entity;

import lombok.Data;

@Data
public class Permissions {
    private Long id; // 权限的ID
    private String name; // 权限的名称
    private String describe; //权限的描述
//    private Integer grade; // 权限等级
}
