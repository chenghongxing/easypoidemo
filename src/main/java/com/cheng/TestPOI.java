package com.cheng;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.cheng.entity.Card;
import com.cheng.entity.Emp;
import com.cheng.entity.Order;
import com.cheng.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
            //身份信息
            Card card = new Card();
            card.setNo("513021199508168574");
            card.setAddress("四川省成都市郫都区红光镇港大路39号优派立方");
            user.setCard(card);
            //订单信息
            Order order = new Order("11111111","超短裙1");
            Order order2 = new Order("11111112","超短裙2");
//            Order order3 = new Order("11111113","超短裙3");
//            Order order4 = new Order("11111114","超短裙4");
            List<Order> list = new ArrayList<>();
            list.add(order);
            list.add(order2);
//            list.add(order3);
//            list.add(order4);
            user.setOrders(list);
            user.setPhoto("C:\\Users\\Admin\\Desktop\\qq.jpg");
            if (i%2 == 0){
                user.setSex("0");
                user.setHobby(Arrays.asList("篮球","足球","羽毛球"));
            }else {
                user.setSex("1");
                user.setHobby(Arrays.asList("喝酒","抽烟","烫头"));
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
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\aa.xls");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

    @Test
    public void test2() throws Exception{
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1);
        importParams.setHeadRows(1);
        //importParams.setStartSheetIndex(2); 表示从第二个sheet页读取，默认是从第一个sheet
        //importParams.setSheetNum(3); 表示读取到最后一个sheet页
        importParams.setImportFields(new String[]{"姓名","爱好"}); //验证Excel是否合法
        List<Emp> emps = ExcelImportUtil.importExcel(new FileInputStream("C:\\Users\\Admin\\Desktop\\rr.xlsx"), Emp.class, importParams);
        emps.forEach(System.out::println);
    }
}
