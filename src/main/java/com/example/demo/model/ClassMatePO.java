package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@lombok.Getter
@lombok.Setter
@Table(name = "classmate",schema = "metadata_student")
public class ClassMatePO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class_no")
    @NotNull
    private String classNo;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonIgnore
    private ClassMatePO parent;

    @JsonIgnore
    @OneToMany(mappedBy="parent",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ClassMatePO> children= new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "classMatePO",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<StudentPO> studentPOS=new HashSet<>();
}
