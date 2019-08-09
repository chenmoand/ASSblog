package com.brageast.blog.util.entity;

public enum State {
    //成功
    SUCCESS(200),

    //失败
    FAIL(400),

    //错误
    FALSE(404),

    //token过期
    EXPIRED(401),

    //无权限
    NODEFINED(403),

    //内部错误
    ERROR(500);



    private Integer code;

    State(Integer code) {
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }

    @Override
    public String toString() {
        return "State{" +
                "code=" + getCode() +
                '}';
    }
}
