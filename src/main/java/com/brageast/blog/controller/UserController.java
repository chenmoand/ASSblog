package com.brageast.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.User;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.PasswordTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    //会报错改成false 就不会了
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page")
    public List<User> getUsers(Integer current, Long size) {
        int ct = current == null? 0 : current;
        long sz = size == null? 10 : size;
        Page<User> page = new Page<>(ct, sz);
        List<User> u = new ArrayList<>();
        userService.getUsers(page).getRecords().forEach(user -> {
            user.setPassword(PasswordTools.decrypt(user.getPassword()));
            u.add(user);
        });
        return u;
    }
    @RequestMapping(value = "/delete")
    public Boolean deleteUser(Integer id) {
        try {
            userService.deleteUser(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Boolean insertUser(@RequestBody User user) {
        try {
            userService.insertUser(user.getId(),user.getName(),user.getPassword(),user.getEmail(),user.getGroup());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping(value = "/updata", method = RequestMethod.POST)
    public Boolean updataUser(@RequestBody User user) {
        try {
            userService.updataUser(user.getId(),user.getName(),user.getPassword(),user.getEmail(),user.getGroup());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
