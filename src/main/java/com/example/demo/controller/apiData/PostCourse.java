package com.example.demo.controller.apiData;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@lombok.Getter
@lombok.Setter
public class PostCourse {
    @Min(0)
    private Integer page;
    @Min(1)
    private Integer size;

    private String like;

    private String isCur;

}
