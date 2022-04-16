package com.guigu.srb.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.guigu.srb.core.pojo.dto.ExcelDictDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelDictListener extends AnalysisEventListener<ExcelDictDTO> {

    //数据列表
    private List<ExcelDictDTO> list = new ArrayList<>();

    //每5条记录批量存储一次数据
    private static final  int BATCH_COUNT = 5;

    @Override
    public void invoke(ExcelDictDTO data, AnalysisContext context) {
        log.info("解析到一条数据" + data);
        //将数据存入数据列表
        list.add(data);
        if (BATCH_COUNT>=5){
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
        //调用mapper层的save方法save list对象
        log.info("数据被存储到数据库成功",list.size());
    }
}
