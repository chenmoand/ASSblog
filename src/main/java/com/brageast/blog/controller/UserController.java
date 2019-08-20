package com.brageast.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brageast.blog.entity.User;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.PasswordTools;
import com.brageast.blog.util.Setting;
import com.brageast.blog.util.entity.Combination;
import com.brageast.blog.util.entity.ResultState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private RestTemplate restTemplate;

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
    @RequestMapping(value = "/updata", method = RequestMethod.POST)
    public ResultState updataUser(@RequestBody User user) {
        return userService.updata(user);

    }
    @RequestMapping(value = "/updataUserGroup", method = RequestMethod.POST)
    public ResultState updataUserGroup(@RequestBody Combination<Integer, Integer> info) {
        return userService.updataUserGroup(info.getEType(), info.getEType());

    }
    @RequestMapping(value = "/github")
    public String github(String code) {
        String str = Setting.Client + code;
        HashMap rg = restTemplate.getForObject(str , HashMap.class);
        HashMap ru = restTemplate.getForObject(Setting.GITHUB_API_USER + rg.get("access_token"), HashMap.class);
        System.out.println(ru);
//        new Page<>()
        return null;
    }
}
