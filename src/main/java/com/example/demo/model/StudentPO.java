package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name")
    private  String name;

    @NotNull
    @Column(name = "sno")
    private String sno;

    @JsonIgnore
    @OneToOne(optional = false,mappedBy = "student",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserPO user;

    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable( name="t_sc", schema = "metadata_student",
            joinColumns = @JoinColumn(name="sid"),
            inverseJoinColumns = @JoinColumn(name="cid"))
    private Set<CoursePO> courses=new HashSet<CoursePO>();

    @JsonIgnore
    @ManyToOne(cascade=CascadeType.ALL,optional=true)
    private ClassMatePO classMatePO;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "profession")
    private String profession;
}
