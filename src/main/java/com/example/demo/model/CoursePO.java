package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@lombok.Getter
@lombok.Setter
@Table(name = "t_course",schema = "metadata_student")
public class CoursePO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JsonIgnore
    @JoinTable(
            name="t_sc",schema="metadata_student",
            joinColumns=@JoinColumn(name="cid", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="sid", referencedColumnName="id"))

    private Set<StudentPO> students=new HashSet<StudentPO>();

    @NotNull
    @Column(name = "cno")
    private String cno;

    @Column(name = "description")
    private String description;

    @Column(name = "count")
    private Integer count;   //当前课程支持的总人数

    @Column(name = "cur_count")
    private Integer curCount;  //当前课程已选人数

    @Column(name = "required")  //是否必修
    private boolean required;
}
