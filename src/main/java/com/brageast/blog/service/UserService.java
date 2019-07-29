package com.brageast.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brageast.blog.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService extends IService<User> {
    Page<User> getUsers(Page<User> page);
    void deleteUser(@Param("id") Integer id);
    void insertUser(@Param("id") Integer id, @Param("name") String name, @Param("password") String password,
                    @Param("email") String email, @Param("group") String group);
    void updataUser(@Param("id") Integer id, @Param("name") String name, @Param("password") String password,
                    @Param("email") String email, @Param("group") String group);
    String getUserPassword(@Param("id") Integer id);
}
