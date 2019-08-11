package com.brageast.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.User;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.PasswordTools;
import com.brageast.blog.util.entity.Combination;
import com.brageast.blog.util.entity.ResultState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@CrossOrigin
// 解决跨域问题的注解
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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultState login(@RequestBody User user) {
        return userService.login(user.getName(), user.getPassword());
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResultState deleteUser(Integer id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultState addtUser(@RequestBody Combination<User, Set<Integer>> cb) {
        User user = cb.getEType();
        return userService.addUser(user.getName(), user.getPassword(), user.getEmail(), cb.getTType());
    }
    @RequestMapping(value="/u/{name}")
    public ResultState findUser(@PathVariable String name){
        return userService.findUser(name);
    }
    /*  @RequestMapping(value = "/updata", method = RequestMethod.POST)
    public Boolean updataUser(@RequestBody User user) {
        try {
            userService.updataUser(user.getId(),user.getName(),user.getPassword(),user.getEmail(),user.getGroup());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
}
