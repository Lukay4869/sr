package com.guigu.srb.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.guigu.srb.core.mapper.DictMapper;
import com.guigu.srb.core.pojo.dto.ExcelDictDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelDictListener extends AnalysisEventListener<ExcelDictDTO> {
    private DictMapper dictMapper;

    //由于这个类没有Component注解，没有自动的被Spring管理，所以这个地方如果使用Resource注解，引入mapper是不行的，需要在类中定义mapper，然后用构造函数注入


    public ExcelDictListener(DictMapper dictMapper) {
        this.dictMapper = dictMapper;
    }

    //数据列表
    private List<ExcelDictDTO> list = new ArrayList<>();

    //每5条记录批量存储一次数据
    private static final  int BATCH_COUNT = 5;

    @Override
    public void invoke(ExcelDictDTO data, AnalysisContext context) {
        log.info("解析到一条数据" , data);
        //将数据存入数据列表
        list.add(data);
        if (list.size()>=BATCH_COUNT){
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //当最后剩余的记录数不足BATCH_COUNT时，最后一次性存储数据
        saveData();
        log.info("所有数据解析完成");
    }
    private void saveData(){
        log.info("{}条数据被存储到数据库",list.size());
        //调用mapper层的批量save方法：save list对象
        dictMapper.insertBatch(list);
        log.info("数据被存储到数据库成功",list.size());
    }
}
