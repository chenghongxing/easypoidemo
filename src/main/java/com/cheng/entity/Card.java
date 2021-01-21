package com.cheng.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

@Data
@ExcelTarget("card")
public class Card implements Serializable {

    @Excel(name = "身份证号",needMerge = true,width = 20.0,orderNum = "6")
    private String no;

    @Excel(name = "籍贯",needMerge = true,width = 40.0,orderNum = "7")
    private String address;
}
