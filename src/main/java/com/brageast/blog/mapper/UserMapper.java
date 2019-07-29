package com.brageast.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.User;

public interface UserMapper extends BaseMapper<User> {
    Page<User> getUsers(Page<User> page);
    void deleteUser(Integer id);
    void insertUser(Integer id, String name, String password,
                    String email, String group);
    void updataUser(Integer id, String name, String password,
                    String email, String group);
    String getUserPassword(Integer id);
}
