package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture {

    @Excel(name = "编号")
    private String id;
    @Excel(name="标题")
    private String title;
    @Excel(name = "头像", type = 2 ,width = 40 , height = 20)
    private String url;
}
