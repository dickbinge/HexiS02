package com.example.demo.entities;

import javax.validation.constraints.NotNull;

@lombok.Getter
@lombok.Setter
public class AddCourseData {
    @NotNull
    private String name;
    @NotNull
    private String cno;
    private String description;
    private Integer count;
    private Integer curCount;
    private boolean required;
}
