package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@lombok.Getter
@lombok.Setter
@Table(name = "t_user", schema = "metadata_student")
public class UserPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   //id主键

    @NotNull
    private String name;  //系统账户名

    @NotNull
    private String password;
    //mappedBy 配置映射关系：当前用户名属于哪个student 对象
    // 默认值optional = true表示idcard_id可以为空;反之。。。
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id",unique = true)
    //unique=true 确保了一对一关系
    private StudentPO student;
    private String email;

}
