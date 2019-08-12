package com.brageast.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brageast.blog.entity.User;
import com.brageast.blog.mapper.UserMapper;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.JwtUtil;
import com.brageast.blog.util.MyPasswordEncoder;
import com.brageast.blog.util.entity.ResultState;
import com.brageast.blog.util.entity.State;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Override
    public Page<User> getUsers(Page<User> page) {
        return baseMapper.getUsers(page);
    }

    @Override
    public ResultState addUser(String name, String password, String email, Set<Integer> groups) {
        // 加密密码
        String pwd = myPasswordEncoder.encode(password);
        try {
            baseMapper.addUser(name, pwd, email);
            final int id = baseMapper.getUserId(name);
            baseMapper.addUserGroup(id , groups);

        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultState(State.FAIL, "用户创建失败");
        }
        return new ResultState(State.SUCCESS, "用户创建成功");
    }

    @Override
    public ResultState deleteUser(Integer id) {
        try {
            baseMapper.deleteUser(id); // 先删除用户
            baseMapper.deleteAllUserGroup(id); // 再删除用户所有组
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultState(State.FAIL, "用户删除失败");
        }
        return new ResultState(State.SUCCESS, "用户删除");
    }

    @Override
    public ResultState findUser(String name) {
        User user;
        try {
            user = baseMapper.findUser(name);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultState(State.FAIL,"系统错误", null);
        }
        return new ResultState(State.SUCCESS,"用户信息如下", user);
    }

    @Override
    public ResultState login(String name, String password) {
        if(name == null && password ==null) return new ResultState(State.FAIL,"用户名或者密码不能为空");
        User user = baseMapper.findUser(name);
        if(user == null) return new ResultState(State.FAIL,"用户不存在");
        if(!myPasswordEncoder.matches(user.getPassword(), password)) return new ResultState(State.FAIL,"密码错误");
        String token = JwtUtil.builder(user);
        return new ResultState(State.SUCCESS,"成功登陆", token);
    }

    @Override
    public ResultState updata(User user) {
        try {
            baseMapper.updateUser(user.getId(), user.getName(), user.getPassword(), user.getEmail());
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultState(State.FAIL,"更新失败");
        }
        return new ResultState(State.SUCCESS,"更新成功");
    }

    @Override
    public ResultState updataUserGroup(Integer User_ID, Integer Group_ID) {
        try {
            baseMapper.updateUserGroup(User_ID, Group_ID);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResultState(State.FAIL,"更新失败");
        }
        return new ResultState(State.SUCCESS,"更新成功");
    }

}
