package com.cheng;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.cheng.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenghx on 2021/1/20 14:42
 */
public class TestPOI {

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(String.valueOf(i));
            user.setName("小程_"+i);
            user.setAge(10+i);
            user.setBir(new Date());
            if (i%2 == 0){
                user.setSex("0");
            }else {
                user.setSex("1");
            }
            users.add(user);
        }
        return users;
    }

    @Test
    public void test() throws IOException {
        //获取数据
        List<User> users = getUsers();
        //导出Excel
        //参数1：exportParams 导出配置对象 参数2:导出的类型 参数3：导出的数据集
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, users);
        //通过流写入指定位置
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\11321\\Desktop\\aa.xls");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }
}
