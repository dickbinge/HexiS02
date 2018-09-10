package com.example.demo.entities;

import javax.validation.constraints.NotNull;

@lombok.Getter
@lombok.Setter
public class EditCourseData {
    private String cno;
    private Integer count;
    private Integer curCount;
    private boolean required;
    private String description;
}
