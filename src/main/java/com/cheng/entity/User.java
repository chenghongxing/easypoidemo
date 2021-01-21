package com.cheng.entity;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chenghx on 2021/1/20 15:03
 */
@Data
@ExcelTarget("users")
public class User implements Serializable {

    //@Excel(name = "编号",orderNum = "0")
    @ExcelIgnore
    private String id;
    
    @Excel(name = "姓名",orderNum = "1",needMerge = true)
    private String name;
    @Excel(name = "性别",needMerge = true,orderNum = "4",replace = {"男_0","女_1"})
    private String sex;
    @Excel(name = "年龄",needMerge = true,orderNum = "3",suffix = "岁")
    private Integer age;
    @Excel(orderNum = "2",needMerge = true,name = "生日",width = 35.0,format = "yyyy-MM-dd HH:mm:ss")
    private Date bir;
    @ExcelIgnore
    private List<String> hobby;
    @Excel(name = "爱好",needMerge = true,orderNum = "5",width = 30.0)
    private String hobbyStr;

    public String getHobbyStr() {
        StringBuilder sb = new StringBuilder();
        hobby.forEach(e->{
            sb.append(e).append("、");
        });
        return sb.toString();
    }

    @ExcelEntity  //标识一一对应关系
    private Card card;

    @ExcelCollection(name = "订单列表",orderNum = "8") //标识一对多关系
    List<Order> orders;

    @Excel(name = "头像",needMerge = true,width = 20,height = 20,type = 2,imageType = 1) //type=2表示图片类型
    private String photo;
}
