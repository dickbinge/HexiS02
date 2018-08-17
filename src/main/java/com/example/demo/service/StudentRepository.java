package com.example.demo.service;

import com.example.demo.model.StudentPO;
import com.example.demo.model.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StudentRepository extends JpaRepository<UserPO,Integer> {
    StudentPO findByName(String name);
//    List<StudentPO> findBySex(char sex);
}
