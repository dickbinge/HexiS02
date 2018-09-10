package com.example.demo.service;

import com.example.demo.model.CoursePO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<CoursePO,Integer> {
    List<CoursePO> findAll();
    CoursePO findOneByCno(String cno);
    @Query(value = "select c from CoursePO  c")
    Page<CoursePO> findByPage(Pageable pageable);

    @Query(value = "select c from CoursePO c where c.name like %:likeString% or c.cno like %:likeString%")
    Page<CoursePO> findByNameLikeOrCnoLike(Pageable pageable,@Param("likeString") String likeString);

    @Query(value = "select  c from CoursePO c where c.required=:isCur")
    Page<CoursePO> findByRequired(@Param("isCur")Boolean isCur,Pageable pageable);

    @Query(value = "select c from CoursePO c where c.required=:isCur and c.name like %:likeString% or c.cno like %:likeString%")
    Page<CoursePO> findByRequiredAndNameLikeAndCnoLike(@Param("isCur")Boolean isCur,@Param("likeString")String likeString,Pageable pageable);
}
