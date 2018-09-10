package com.example.demo.entities;

import javax.validation.constraints.NotNull;

@lombok.Getter
@lombok.Setter
public class LoginCheckData {
    @NotNull
    private String username;
    private String password;
}
