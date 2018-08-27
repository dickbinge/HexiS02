package com.example.demo.service;

import com.example.demo.controller.apiData.PageModel;
import com.example.demo.model.UserPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface UserRepository extends JpaRepository<UserPO,Integer>{
    List<UserPO> findAll();
    UserPO findById(Integer id);
    UserPO findByName(String name);
    UserPO findByNameAndPassword(String name,String password);
    @Query(value = "select u from UserPO u")
    Page<UserPO> findAllUser(Pageable page); //分页查询
    @Query(value = "select u from UserPO u where u.name like %:likeString%")
    Page<UserPO> findByLike(@Param( "likeString" )String likeString, Pageable page);
}
