package com.brageast.blog;

import com.brageast.blog.entity.Group;
import com.brageast.blog.util.Formula;

public class MainTests {

    public static void main(String[] args) {
        Group g = new Group();
        /*long startTime = System.currentTimeMillis();
        EntityUtil.println("abcdefg",true, new Date());
//        System.out.println("abcdefg"+true+new Date());
        long doneTime = System.currentTimeMillis();
        System.out.println(doneTime - startTime);*/

//        ExceptionUtil.isException(() ->{
//
//        }, Exception.class);
        int a = 1;

        Formula.A_greater_B(a , 10).Return();
    }
}
