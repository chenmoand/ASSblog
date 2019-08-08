package com.brageast.blog.util;

import com.brageast.blog.util.entity.Combination;

import java.util.HashSet;
import java.util.Set;

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
}
