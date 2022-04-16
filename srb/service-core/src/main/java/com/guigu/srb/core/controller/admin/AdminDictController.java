package com.guigu.srb.core.controller.admin;


import com.alibaba.excel.EasyExcel;
import com.guigu.common.exception.BusinessException;
import com.guigu.common.result.R;
import com.guigu.common.result.ResponseEnum;
import com.guigu.srb.core.pojo.dto.ExcelDictDTO;
import com.guigu.srb.core.pojo.entity.Dict;
import com.guigu.srb.core.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author magic
 * @since 2022-04-14
 */
@Api(tags = "数据字典管理")
@RestController
@RequestMapping("/admin/core/dict")
@Slf4j
@CrossOrigin
public class AdminDictController {
    @Resource
    private DictService dictService;

    @ApiOperation("Excel数据批量导入")
    @PostMapping("import")
    public R batchImport(
            @ApiParam(value = "Excel数据字典文件", required = true)
            @RequestPart("file") MultipartFile file) {

        try {
            InputStream inputStream = file.getInputStream();
            dictService.importData(inputStream);

            return R.ok().message("数据字典数据批量导入成功");

        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.UPLOAD_ERROR, e);
        }
    }

    @ApiOperation("Excel导出")
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        //注意这里用swagger测的时候会有问题，可以使用浏览器或者postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("Mydict", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" +
                fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ExcelDictDTO.class).sheet("模板").doWrite(dictService.listDictData());


    }

    @ApiOperation("根据上级id获取子节点数据列表")
    @GetMapping("/listByParentId/{parentId}")
    public R listByParentId(
            @ApiParam(value = "上级节点id", required = true)
            @PathVariable Long parentId
    ) {
       List<Dict> dictList = dictService.listByParentId(parentId);
       return R.ok().data("list",dictList);
    }

}

