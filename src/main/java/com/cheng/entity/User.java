package com.cheng.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenghx on 2021/1/20 15:03
 */
@Data
@ExcelTarget("users")
public class User implements Serializable {

    @Excel(name = "编号",orderNum = "0")
    private String id;
    @Excel(name = "姓名",orderNum = "1")
    private String name;
    @Excel(name = "性别",orderNum = "4",replace = {"男_0","女_1"})
    private String sex;
    @Excel(name = "年龄",orderNum = "3",suffix = "岁")
    private Integer age;
    @Excel(orderNum = "2",name = "生日",width = 35.0,format = "yyyy-MM-dd HH:mm:ss")
    private Date bir;
}
