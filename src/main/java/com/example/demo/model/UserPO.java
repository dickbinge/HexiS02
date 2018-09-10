package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@lombok.Getter
@lombok.Setter
@Table(name = "t_user", schema = "metadata_student")
public class UserPO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   //id主键

    @NotNull
    @Column(name = "name")
    private String name;  //系统账户名

    @NotNull
    @Column(name = "password")
    private String password;
    @NotNull
    @Column(name = "sno")
    private String sno;
    //mappedBy 配置映射关系：当前用户名属于哪个student 对象
    // 默认值optional = true表示idcard_id可以为空;反之。。。
    @JsonIgnore
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id",unique = true)
    //unique=true 确保了一对一关系
    private StudentPO student;
    private String email;

}
