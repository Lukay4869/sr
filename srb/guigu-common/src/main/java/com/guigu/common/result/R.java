package com.guigu.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//封装结果集
@Data
public class R {
    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap<>();

    //构造函数私有化
    private R(){}

    //返回成功后的结果
    public static R ok(){
        R r = new R();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }

    //返回失败后的结果
    public static R error(){
        R r = new R();
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(ResponseEnum.ERROR.getMessage());
        return r;
    }

    //设置特定的结果
    public static R setResult(ResponseEnum responseEnum){
        R r = new R();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;
    }
}
