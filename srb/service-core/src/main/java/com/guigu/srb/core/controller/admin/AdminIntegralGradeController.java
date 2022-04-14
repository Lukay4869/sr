package com.guigu.srb.core.controller.admin;


import com.guigu.srb.core.entity.IntegralGrade;
import com.guigu.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author magic
 * @since 2022-04-14
 */
@Api(tags = "积分等级管理")//swagger的注解，使用之后，可以在swagger中看到tags的内容
@CrossOrigin
@RestController
@RequestMapping("/admin/core/integralGrade")
public class AdminIntegralGradeController {

    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation(value = "积分等级列表",notes = "这里可以描述更详细的信息")//会在swagger的对应测试方法上输出
    @GetMapping("/list")
    public List<IntegralGrade> listAll(){
        List<IntegralGrade> list = integralGradeService.list();
        return list;
    }

    @ApiOperation(value = "根据id删除记录",notes = "逻辑删除数据")
    @DeleteMapping("/delete/{id}")
    public boolean deleteById(
            @ApiParam(value = "数据id",example = "例子")//参数级别的注解
            @PathVariable Long id){
       return integralGradeService.removeById(id);
    }

}

