package com.example.demo.entities;

import javax.validation.constraints.NotNull;

@lombok.Getter
@lombok.Setter
public class AddUserData {
    @NotNull
    private String name;   //当前学生输入的用户名，登录用的用户名
    private String password; //登录的密码
    private String sno;     //登录学生的学号
    private String email;   //登录学生注册的邮箱
}
