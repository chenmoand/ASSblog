package com.brageast.blog.util.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Autho chenmo
 * @param <E> 参数e
 * @param <T> 参数t
 * @descirbe 用于快速的整合一个实体 结合EntityUtil使用
 */

@Data
public class Combination<E,T> {
    private E eType;
    private T tType;
    public String toJsonString() {
        return JSON.toJSONString(this);
    }

}
