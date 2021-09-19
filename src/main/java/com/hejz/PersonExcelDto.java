package com.hejz;

import lombok.Data;

import java.util.Date;

@Data
public class PersonExcelDto {
    private String name;
    private Integer age;
    private Date birthday;
}
