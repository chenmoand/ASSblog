package com.brageast.blog.util.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class ResultState {

    private Integer code = State.FALSE.getCode();
    private String msg = " ";
    private Object data = null;

    public ResultState(){};

    public ResultState(State code, String msg) {
        this.code = code.getCode();
        this.msg = msg;
    }

    public ResultState(State code, Object data) {
        this.code = code.getCode();
        this.data = data;
    }

    public ResultState(State code, String msg, Object data) {
        this.code = code.getCode();
        this.msg = msg;
        this.data = data;
    }
    // 因为fastJson 转化为Json后居然式State = "FALSE"这样
    // 坑啊我都连state 的toString都重写了都不行,只能这样了
    public void setCode(State code) {
        this.code = code.getCode();
    }

    @Override
    public String toString() {
        return "ResultState{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
    // 请叫我秀儿
    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
