package com.cheng.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ExcelTarget("emp")
public class Emp implements Serializable {

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "性别",replace = {"男_0","女_1"})
    private String sex;

    @Excel(name = "年龄")
    private Integer age;

    @Excel(name = "生日",format = "yyyy-MM-dd HH:mm:ss")
    private Date bir;
}
