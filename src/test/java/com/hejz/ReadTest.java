package com.hejz;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.hejz.listener.PersonDataListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ReadTest {
    /**
     * jdk8不使用再写监听器，使用PageReadListener即可
     */
    @Test
    public void jdk8readTest(){
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = "/Users/hejianzhe/Desktop/simpleWrite.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, PersonExcelDto.class, new PageReadListener<PersonExcelDto>(dataList -> {
            for (PersonExcelDto demoData : dataList) {
                log.info("读取到一条数据{}", demoData);
            }
        })).sheet().doRead();
    }

    /**
     * xlsx普通测试——excelType中默认读取，如果需要读取xls或csv格式需要加excelType设置
     */
    @Test
    public void xlsxreadTest(){
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法3：
        String fileName = "/Users/hejianzhe/Desktop/simpleWrite.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, PersonExcelDto.class, new PersonDataListener()).sheet().doRead();

    }
}
