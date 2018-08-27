package com.example.demo.controller.apiData;

import javax.validation.constraints.Min;

@lombok.Getter
@lombok.Setter
public class UserRequestData {

    @Min(0)           //校验，当前最小值为0
    private int page;
    @Min(1)
    private int size;

    private  String like;
}
