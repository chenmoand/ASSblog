package com.brageast.blog.util;

import com.brageast.blog.util.entity.Combination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author chenmo
 * 这是一些对实体操作的类
 * 自己创建点语法糖qwq
 */

public class EntityUtil {

    // 配合Combination食用更佳
    public static <E,T> Combination<E,T> getEntity(E e, T t){
        Combination<E,T> cob = new Combination<>();
        cob.setEType(e);
        cob.setTType(t);
        return cob;
    }
    public static <E,T> Set<Combination<E,T>> getEntity(E[] e, T[] t){
        if(e.length != t.length) return null;
        Set<Combination<E,T>> sc = new HashSet<>();
        for(int i = 0; i < e.length; i++){
            sc.add(getEntity(e[i], t[i]));
        }
        return sc;
    }
    // 向Python 那样输出
    // 将+号连接符试图换成逗号qwq
    public static String toString(Object... objs){
        StringBuffer sb  = new StringBuffer();
        Arrays.asList(objs).forEach(val -> sb.append(val.toString()));
        return sb.toString();
    }
    public static void println(Object... objs) {
        log(System.out::println, objs);
    }
    public static void print(Object... objs) {
        log(System.out::print, objs);
    }

    /**
     * 用法 : EntityUtil.log(log::info,"demo", "sda", 1, new date());
     * 是不是方便了很多qwq, 这该死的语法糖
     * @param log
     * @param objs
     */
    public static void log(Ilog log, Object... objs) {
        log.init(toString(objs));
    }
    @FunctionalInterface
    public interface Ilog {
        void init(String str);
    }
}
