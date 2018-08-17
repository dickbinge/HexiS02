package com.example.demo.service;

import com.example.demo.controller.apiData.PageModel;
import com.example.demo.model.UserPO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@NoRepositoryBean
public interface UserRepository extends JpaRepository<UserPO,Integer>{
    List<UserPO> findAll();
    UserPO findById(Integer id);
    UserPO findByName(String name);
    UserPO findByNameAndPassword(String name,String password);
    //@Query(value = "select u from UserPO u where u.assign='t'")
    //Page<UserPO> findAll(PageModel page); //分页查询
}
