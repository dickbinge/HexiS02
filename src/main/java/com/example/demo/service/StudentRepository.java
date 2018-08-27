package com.example.demo.service;

import com.example.demo.model.StudentPO;
import com.example.demo.model.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StudentRepository extends JpaRepository<StudentPO,Integer> {
    StudentPO findByName(String name);
    StudentPO findBySno(String sno);
//    List<StudentPO> findBySex(char sex);
}
