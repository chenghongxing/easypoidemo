package com.cheng.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ExcelTarget("order")
public class Order implements Serializable {
    @Excel(name = "订单编号",width = 30.0,orderNum = "8")
    private String orderNo;

    @Excel(name = "订单名称",width = 20.0,orderNum = "9")
    private String orderName;
}
