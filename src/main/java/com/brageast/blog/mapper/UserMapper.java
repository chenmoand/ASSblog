package com.brageast.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.User;

import java.util.Set;

public interface UserMapper extends BaseMapper<User> {
    // 分页查看用户们
    Page<User> getUsers(Page<User> page);
    // 添加用户
    void addUser(String name, String password, String email);
    // 给用户添加组
    void addUserGroup(Integer user_id, Set<Integer> group_id);
    // 得到用户的id
    Integer getUserId(String name);
    //删除用户
    void deleteUser(Integer id);
    // 删除所有用户组
    void deleteAllUserGroup(Integer user_id);
    // 更新用户信息
    void updateUser(Integer id, String name, String password, String email);
    // 更新用户组
    void updateUserGroup(Integer user_id, Integer group_id);
    // 删除用户的一个组
    void  deleteUserGroup(Integer user_id, Integer group_id);
    // 查找用户
    User findUser(String name);

}
