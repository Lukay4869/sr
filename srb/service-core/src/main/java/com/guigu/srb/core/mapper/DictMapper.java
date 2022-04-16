package com.guigu.srb.core.mapper;

import com.guigu.srb.core.pojo.dto.ExcelDictDTO;
import com.guigu.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 数据字典 Mapper 接口
 * </p>
 *
 * @author magic
 * @since 2022-04-14
 */
public interface DictMapper extends BaseMapper<Dict> {

    void insertBatch(List<ExcelDictDTO> list);
}
