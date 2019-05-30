package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @ExcelIgnore
    private Integer id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "密码")
    private String password;
    @Excel(name = "生日",format = "yyyy-MM-dd")
    private Date bir;
}
