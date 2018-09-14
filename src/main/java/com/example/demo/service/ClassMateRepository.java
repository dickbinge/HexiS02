package com.example.demo.service;

import com.example.demo.model.ClassMatePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ClassMateRepository extends JpaRepository<ClassMatePO,Integer> {
    List<ClassMatePO> findByParentIsNull();  //查找所有的一级分组
}
