package com.hejz.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.hejz.PersonExcelDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonDataListener extends AnalysisEventListener<PersonExcelDto> {
    @Override
    public void invoke(PersonExcelDto personExcelDto, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}",personExcelDto);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据获取完毕！");
    }
}
