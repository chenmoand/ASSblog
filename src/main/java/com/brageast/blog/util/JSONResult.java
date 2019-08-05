package com.brageast.blog.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class JSONResult {

    public static String fillResultString(Integer status, String message, Object result) {
        // 雾, 我只是个无情的代码搬运工
        return JSON.toJSONString(new HashMap<String, Object>(){{
            put("status", status); put("message", message); put("result", result);
        }});
    }
}
