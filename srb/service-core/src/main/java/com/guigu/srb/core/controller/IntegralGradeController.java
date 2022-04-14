package com.guigu.srb.core.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author magic
 * @since 2022-04-14
 */
@Api(tags = "积分网站接口")
@RestController
@RequestMapping("/integralGrade")
public class IntegralGradeController {
    @GetMapping("/test")
    public void test(){
        return;
    }

}

