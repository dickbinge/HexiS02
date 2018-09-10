package com.example.demo.service;

import com.example.demo.model.StudentPO;
import com.example.demo.model.UserPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StudentRepository extends JpaRepository<StudentPO,Integer> {
    StudentPO findByName(String name);
    StudentPO findOneBySno(String sno);

    @Query(value = "select p from StudentPO p")
    Page<StudentPO> findByPage(Pageable pageable);

    @Query(value = "select p from StudentPO p where p.name like %:likeString%")
    Page<StudentPO> findByLike(@Param( "likeString" )String likeString, Pageable pageable);

    @Query(value = "select p from StudentPO  p where p.sex=(:sex)")
    Page<StudentPO> findBySex(@Param( "sex" )String sex,Pageable pageable);

    @Query(value = "select p from StudentPO p where p.name like %:likeString% and p.sex=(:sex)")
    Page<StudentPO> findByLikeAndSex(@Param( "likeString")String likeString,@Param("sex")String sex,Pageable pageable);
}
