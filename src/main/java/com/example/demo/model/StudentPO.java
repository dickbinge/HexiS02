package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@lombok.Getter
@lombok.Setter
@Table(name = "t_student", schema = "metadata_student")
public class StudentPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private  String name;

    @NotNull
    private String sno;

    @OneToOne(optional = false,mappedBy = "student",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserPO user;

    @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable( name="t_sc", schema = "metadata_student",
            joinColumns = @JoinColumn(name="sid"),
            inverseJoinColumns = @JoinColumn(name="cid"))
    private Set<CoursePO> courses=new HashSet<CoursePO>();

    private char sex;

    private int age;

    private String email;

    private String address;

    private String profession;
}
