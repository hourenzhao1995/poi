package com.baizhi;

import com.baizhi.entity.Student;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiOutTests {

    @Test
    public void contextLoads() throws IOException {

        //1.创建excle文档
        HSSFWorkbook workbook = new HSSFWorkbook();

        //2.创建Excel 的工作表
        HSSFSheet sheet = workbook.createSheet("test");

        //3.创建excle的行
        HSSFRow row = sheet.createRow(0);

        //4.创建单元格
        HSSFCell cell = row.createCell(0);

        //5.单元格设值
        cell.setCellValue(10.0);

        //6.写到本地
        workbook.write(new File("D:/aa.xls"));

    }

    @Test
    public void contextLoads1() throws IOException {

        //1.创建文档
        HSSFWorkbook workbook = new HSSFWorkbook();

        //通过workbook创建日期的格式
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");

        //通过workbook创建cellStyle
        HSSFCellStyle cellStyle = workbook.createCellStyle();

        //通过cellStyle设置日期的格式
        cellStyle.setDataFormat(format);

        //2.创建工资表
        HSSFSheet sheet = workbook.createSheet("test1");
        sheet.setColumnWidth(0, 20 * 256);

        //3.创建行
        HSSFRow row = sheet.createRow(0);
        //4.创建单元格
        HSSFCell cell = row.createCell(0);
        //5.单元格设值
        cell.setCellValue(new Date());
        //单元格设值指定的cellStyle
        cell.setCellStyle(cellStyle);
        workbook.write(new File("D:/bbb.xls"));
    }

    @Test
    public void contextLoads2() throws IOException {
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
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFFont font = workbook.createFont();
        font.setFontName("楷体");
        font.setBold(true);
        font.setColor(Font.COLOR_RED);

        HSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd");
        HSSFCellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1.setDataFormat(format);


        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        HSSFSheet sheet = workbook.createSheet("学生");
        sheet.setColumnWidth(3,20*256);
        HSSFRow row = sheet.createRow(0);
        String[] titles = {"编号", "姓名", "密码", "生日"};
        for (int i = 0; i < titles.length; i++) {
            String title = titles[i];
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(title);
            cell.setCellStyle(cellStyle);
        }
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(list.get(i).getId());
            row1.createCell(1).setCellValue(list.get(i).getName());
            row1.createCell(2).setCellValue(list.get(i).getPassword());
            HSSFCell cell = row1.createCell(3);
            cell.setCellValue(list.get(i).getBir());
            cell.setCellStyle(cellStyle1);

        }

        workbook.write(new File("D:/student.xls"));

    }
}
