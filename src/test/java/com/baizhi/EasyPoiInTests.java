package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyPoiInTests {

    @Test
    public void contextLoads() throws Exception {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        /*List<Student> result = ExcelImportUtil.importExcel(new FileInputStream("D:/studentttt.xls"),
                Student.class, params);*/
        List<Student> list = ExcelImportUtil.importExcel(
                new FileInputStream("D:/student.xls"),
                Student.class, params);
        for (Student student : list) {
            System.out.println(student);
        }
    }
    @Test
    public void contextLoads1() throws Exception {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(2);
        List<Teacher> list = ExcelImportUtil.importExcel(
                new FileInputStream("D:/teacher.xls"),
                Teacher.class, params);
        for (Teacher teacher : list) {
            List<Student> list1 = teacher.getList();
        }



    }
}
