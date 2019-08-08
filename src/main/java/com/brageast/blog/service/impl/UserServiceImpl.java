package com.brageast.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brageast.blog.entity.User;
import com.brageast.blog.mapper.UserMapper;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.PasswordTools;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
   @Override
    public Page<User> getUsers(Page<User> page) {
        return baseMapper.getUsers(page);
    }

    @Override
    public boolean addUser(String name, String password, String email, Set<Integer> groups) {
        // 加密密码
        String pwd = PasswordTools.encrypt(password);
        try {
            baseMapper.addUser(name, pwd, email);
            final int id = baseMapper.getUserId(name);
            baseMapper.addUserGroup(id , groups);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(Integer id) {
        try {
            baseMapper.deleteUser(id); // 先删除用户
            baseMapper.deleteAllUserGroup(id); // 再删除用户所有组
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*  @Override
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
 */
    @Override
    public User findUser(String name) {
        return baseMapper.findUser(name);
    }

    public String encrypt(String password){
        if(password == null) return null;
        return PasswordTools.encrypt(password);
    }
}
