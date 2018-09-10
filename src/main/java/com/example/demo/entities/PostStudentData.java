package com.example.demo.entities;

import javax.validation.constraints.NotNull;

@lombok.Getter
@lombok.Setter
public class PostStudentData {
    @NotNull
    private String sno;
    private String sex;
    private int age;
    private String email;
    private String address;
    private String profession;
}
