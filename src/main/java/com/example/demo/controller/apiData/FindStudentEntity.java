package com.example.demo.controller.apiData;

import javax.validation.constraints.Min;

@lombok.Setter
@lombok.Getter
public class FindStudentEntity {
    @Min(0)           //校验，当前最小值为0
    private int page;
    @Min(1)
    private int size;

    private  String like;
    private String sex;
}
