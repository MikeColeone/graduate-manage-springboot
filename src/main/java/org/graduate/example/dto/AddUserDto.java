package org.graduate.example.dto;


import lombok.Data;


//导入学生信息

@Data
public class AddUserDto {
    private String account;
    private String department;

    //班级 例如： 2022级2班
    private String className;
    //专业排名
    private Integer rank;

}
