package com.brageast.blog;

import com.brageast.blog.util.EntityUtil;

import java.util.Date;

public class MainTests {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        EntityUtil.println("abcdefg",true, new Date());
//        System.out.println("abcdefg"+true+new Date());
        long doneTime = System.currentTimeMillis();
        System.out.println(doneTime - startTime);
    }
}
