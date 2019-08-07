package com.brageast.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface UserMapper extends BaseMapper<User> {
    Page<User> getUsers(Page<User> page);
    boolean addUser(String name, String password,
                    String email);
    boolean addUserGroup(Integer user_id, Set<Integer> groupsid);
    Integer getUserId(String name);
    /* void deleteUser(Integer id);
    void insertUser(Integer id, String name, String password,
                    String email, String group, String permissions);
    void updataUser(Integer id, String name, String password,
                    String email, String group, String permissions);*/
    User findUser(String name);

}
