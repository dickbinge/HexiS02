package com.example.demo.controller;

import com.example.demo.controller.apiData.PageModel;
import com.example.demo.model.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import  com.example.demo.service.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/user")
public class UserController {
    @Autowired
    private  UserRepository repository;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<?> getUserList(){
        ResponseEntity<?> resEntity=null;
        try{
            List<UserPO> data=repository.findAll();
            PageModel pageModel=new PageModel();
            pageModel.setTotalCount(data.size());
            pageModel.setData( data );
            resEntity = new ResponseEntity<>(pageModel, HttpStatus.OK);
            System.out.println("respEntity = " + resEntity);

        }catch (Exception ex){
            resEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resEntity;
    }
}
