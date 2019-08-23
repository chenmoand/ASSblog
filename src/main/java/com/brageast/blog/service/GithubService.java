package com.brageast.blog.service;

import com.brageast.blog.util.entity.ResultState;

public interface GithubService {

    // 创建一个github用户 返回一个Token + 用户名
    ResultState createGithubUser(String code);

}
