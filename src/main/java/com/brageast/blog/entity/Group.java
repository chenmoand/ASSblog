package com.brageast.blog.entity;


import lombok.Data;

@Data
public class Group {

    private Long id; // 组的编号
    private String name; // 组的名称
//    private Integer grade; // 组的权限等级
    private String describe; // 组的描述

//    private Set<Permissions> permissions; // 组的权限
//    private String father; // 组的父组只能有一个

}
