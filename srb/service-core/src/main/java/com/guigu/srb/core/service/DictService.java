package com.guigu.srb.core.service;

import com.guigu.srb.core.pojo.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author magic
 * @since 2022-04-14
 */
public interface DictService extends IService<Dict> {
    void importData(InputStream inputStream);

}
