package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyPoiTests {

    @Test
    public void contextLoads() throws IOException {
        List<Student> list = new ArrayList<>();
        Student student = new Student(1, "zhangsan", "000", new Date());
        Student student1 = new Student(2, "lisi", "000", new Date());
        Student student2 = new Student(3, "wangzhu", "000", new Date());
        Student student3 = new Student(4, "zhaoliu", "000", new Date());
        Student student4 = new Student(5, "隔壁老王", "000", new Date());
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("150班学生","学生信息表"),
                Student .class, list);

        workbook.write(new FileOutputStream("D:/easypoiStudent.xls"));
    }
    @Test
    public void test1() throws IOException {
        List<Student> list = new ArrayList<>();
        Student student = new Student(1, "zhangsan", "000", new Date());
        Student student1 = new Student(2, "lisi", "000", new Date());
        Student student2 = new Student(3, "wangzhu", "000", new Date());
        Student student3 = new Student(4, "zhaoliu", "000", new Date());
        Student student4 = new Student(5, "隔壁老王", "000", new Date());
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher = new Teacher("1", "张三", list);
        Teacher teacher1 = new Teacher("2", "李四", list);
        teachers.add(teacher);
        teachers.add(teacher1);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("150班学生","学生信息表"),
                Teacher.class, teachers);

        workbook.write(new FileOutputStream("D:/teacher.xls"));
    }

}
