package com.brageast.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brageast.blog.entity.User;
import org.apache.ibatis.annotations.Param;

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
    boolean addUser(String name, String password,
                    String email, Set<Integer> group_id);
    boolean deleteUser(Integer id);
    User findUser(String name);
}
