package com.brageast.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brageast.blog.entity.User;
import com.brageast.blog.mapper.UserMapper;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.PasswordTools;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public Page<User> getUsers(Page<User> page) {
        return baseMapper.getUsers(page);
    }

    @Override
    public void deleteUser(Integer id) {
        baseMapper.deleteUser(id);
    }

    @Override
    public void insertUser(Integer id, String name, String password, String email, String group, String permissions) {
        String pwd = encrypt(password);
        baseMapper.insertUser(id, name, pwd, email, group, permissions);
    }

    @Override
    public void updataUser(Integer id, String name, String password, String email, String group, String permissions) {
        String pwd = encrypt(password);
        baseMapper.updataUser(id, name, pwd, email, group, permissions);
    }

    @Override
    public User findUser(Integer id) {
        return baseMapper.findUser(id);
    }

    public String encrypt(String password){
        if(password == null) return null;
        return PasswordTools.encrypt(password);
    }
}
