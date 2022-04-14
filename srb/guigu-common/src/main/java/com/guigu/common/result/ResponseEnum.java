package com.guigu.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum  ResponseEnum {
    SUCCESS(0,"成功"),
    ERROR(-1,"失败");
    //响应状态码
    private Integer code;
    //响应信息
    private String message;
}
