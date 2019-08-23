package com.brageast.blog.service.impl;

import com.brageast.blog.entity.User;
import com.brageast.blog.service.GithubService;
import com.brageast.blog.service.UserService;
import com.brageast.blog.util.EntityUtil;
import com.brageast.blog.util.JwtUtil;
import com.brageast.blog.util.Setting;
import com.brageast.blog.util.entity.ResultState;
import com.brageast.blog.util.entity.State;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.HashSet;

@Slf4j
@Service
public class GithubServiceImpl implements GithubService {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResultState createGithubUser(String code) {
        try {
            final String str = Setting.Client + code;
//            final ResultState rs = EntityUtil.getEntity(onCreateGithubUser(str));
            return EntityUtil.getEntity(onCreateGithubUser(str), "系统错误");

        } catch (Exception e) {
            // 拦截所有报错
            log.error(e.getMessage());
            return new ResultState(State.FAIL, "code过期或者系统错误");
        }
    }

    public ResultState onCreateGithubUser(String code) throws Exception {
        final String access_token = getAccessToken(code);
        final HashMap<String, Object> userinfo = getGithubUserInfo(access_token);
        final String name = "github_" + userinfo.get("login");
        final String token = onGithubUser(name, userinfo);

        return new ResultState(State.SUCCESS, (String) userinfo.get("login"), token);
    }

    /**
     * 是否有这个用户
     * @return Token
     */
    public String onGithubUser(String name, HashMap<String, Object> userinfo) {
        final ResultState rs = userService.findUser(name);
        if(rs.getData() != null){
            return JwtUtil.builder((User) rs.getData());
        }
        userService.addUser(
                name,
                "123456",
                userinfo.get("email") == null ? "123456@brageast.com" : (String) userinfo.get("email"),
                new HashSet<Integer>(){{add(999);}}
        );
        // 这样写理论上不会出现任何毛病 如何出现了异常直接拦截
        return onGithubUser(name, userinfo);

    }

    public HashMap<String, Object> getGithubUserInfo(String access_token){

        return EntityUtil.getEntity(
                restTemplate.getForObject(Setting.GITHUB_API_USER + access_token, HashMap.class)
                , "未找到Github用户信息"
        );
    }

    public String getAccessToken(String str) {
        return EntityUtil.getEntity(
                (String) restTemplate.getForObject(str , HashMap.class).get("access_token")
                ,"未找到access_token"
        );
    }


}
