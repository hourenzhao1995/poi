package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyPoiPictureTests {

    @Test
    public void contextLoads() throws IOException {
        ArrayList<Picture> list = new ArrayList<>();
        Picture picture = new Picture("1", "测试", "D:\\后期项目代码\\cmfz\\src\\main\\webapp\\img\\A2.jpg");
        Picture picture1 = new Picture("2", "测试1", "D:\\后期项目代码\\cmfz\\src\\main\\webapp\\img\\shouye.jpg");
        Picture picture2 = new Picture("3", "测试2", "D:\\后期项目代码\\cmfz\\src\\main\\webapp\\img\\captcha.jpg");
        list.add(picture);
        list.add(picture1);
        list.add(picture2);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("150班学生","学生信息表"),
                Picture.class, list);
        workbook.write(new FileOutputStream("D:/picture.xls"));
    }
}
