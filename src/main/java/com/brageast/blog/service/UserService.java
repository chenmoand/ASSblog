package com.brageast.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brageast.blog.entity.User;
import com.brageast.blog.util.entity.ResultState;

import java.util.Set;

public interface UserService extends IService<User> {
    /**
     *
     *  @param page
     *  @return Page<User> 一个用户的分页
     *  例子 : getUsers(new Page<>(1, 5));
     *
     */
    Page<User> getUsers(Page<User> page);
    ResultState addUser(String name, String password,
                    String email, Set<Integer> group_id);
    ResultState deleteUser(Integer id);
    ResultState findUser(String name);
    ResultState login(String name, String password);
}
