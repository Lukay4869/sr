package com.guigu.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    //构造方法私有化
    private R() {
    }

    //返回成功的结果
    public static R ok() {
        R r = new R();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }

    //返回失败的结果
    public static R error() {
        R r = new R();
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(ResponseEnum.ERROR.getMessage());
        return r;
    }

    //设置特定的结果
    public static R setResult(ResponseEnum responseEnum) {
        R r = new R();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;
    }

    //设置返回的数据
    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    //如果直接返回一个集合的话，直接返回就可以了
    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    //设置特定的响应消息
    public R message(String message){
        this.setMessage(message);
        return this;
    }

    //设置特定的响应码
    public R code(Integer code){
this.setCode(code);
return this;
    }
}
