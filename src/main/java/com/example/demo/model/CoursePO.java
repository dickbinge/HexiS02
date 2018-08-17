package com.example.demo.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;
    @ManyToMany(fetch=FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})

    @JoinTable(
            name="t_sc",schema="metadata_student",
            joinColumns=@JoinColumn(name="cid", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="sid", referencedColumnName="id"))

    private Set<StudentPO> students=new HashSet<StudentPO>();

    @NotNull
    private String cno;

    private String description;

}
