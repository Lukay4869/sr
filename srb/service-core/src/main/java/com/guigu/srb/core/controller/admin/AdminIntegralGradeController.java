package com.guigu.srb.core.controller.admin;


import com.guigu.common.exception.BusinessException;
import com.guigu.common.result.R;
import com.guigu.common.result.ResponseEnum;
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
    public R listAll(){
        List<IntegralGrade> list = integralGradeService.list();
        return R.ok().data("list",list).message("获取列表成功");//此message是在R类里创建的方法，用于返回成功信息
    }

    @ApiOperation(value = "根据id删除记录",notes = "逻辑删除数据")
    @DeleteMapping("/delete/{id}")
    public R deleteById(
            @ApiParam(value = "数据id",example = "例子")//参数级别的注解
            @PathVariable Long id){
        boolean result = integralGradeService.removeById(id);
        if (result){
            return R.ok().message("删除成功");
        }else {
            return R.error().message("删除失败");
        }
    }

    @ApiOperation("保存积分等级")
    @PostMapping("/save")
    public R save(
            @ApiParam(value = "积分等级对象",required = true)
           @RequestBody IntegralGrade integralGrade){
        if (integralGrade.getBorrowAmount() == null){
throw new  BusinessException(ResponseEnum.BORROW_AMOUNT_NULL_ERROR);
        }
        boolean save = integralGradeService.save(integralGrade);
        if (save){
          return   R.ok().message("保存成功");
        }else {
          return   R.error().message("保存失败");
        }

    }

    @ApiOperation("根据id获取积分等级")
    @GetMapping("/get/{id}")
    public R getById(@ApiParam(value = "想要查询的id",required = true,example = "1")
                     @PathVariable Long id
                     ){
        IntegralGrade byId = integralGradeService.getById(id);
        if (byId != null){
           return R.ok().message("获取数据成功");
        }else {
           return R.error().message("没有该数据");
        }
    }

    @ApiOperation("根据id更新积分")
    @PutMapping("update/{id}")
    public R updateById(@ApiParam(value = "积分等级对象")@RequestBody IntegralGrade integralGrade){
        boolean b = integralGradeService.updateById(integralGrade);
        if (b){
          return   R.ok().message("根据id更新成功");
        }else {
          return   R.ok().message("根据id更新失败");
        }
    }

}

