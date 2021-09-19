package com.hejz;

import com.alibaba.excel.EasyExcel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WriteTest {
    @Test
    public void writeTest() {
        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = "/Users/hejianzhe/Desktop/simpleWrite.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, PersonExcelDto.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });

    }

    private List<PersonExcelDto> data() {
        List<PersonExcelDto> list = new ArrayList<PersonExcelDto>();
        for (int i = 0; i < 10; i++) {
            PersonExcelDto data = new PersonExcelDto();
            data.setName("姓名" + i);
            data.setBirthday(new Date());
            data.setAge(20);
            list.add(data);
        }
        return list;
    }
}
