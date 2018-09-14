package com.example.demo.controller;

import com.example.demo.components.UserDataMgmt;
import com.example.demo.controller.apiData.PageModel;
import com.example.demo.controller.apiData.UserRequestData;
import com.example.demo.entities.AddUserData;
import com.example.demo.entities.ErrorHandler;
import com.example.demo.entities.LoginCheckData;
import com.example.demo.model.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import  com.example.demo.service.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1.0/user")
public class UserController {
    @Autowired private  UserRepository repository;
    @Autowired private UserService userService;
    @Autowired private UserDataMgmt userDataMgmt;

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String getUserInfo(){
        return "HelloWorld";
    }

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

    @RequestMapping(value = "find",method = RequestMethod.POST)
    public ResponseEntity<?> findUser(@RequestBody  UserRequestData requestData){
        Pageable page=new PageRequest(requestData.getPage(),requestData.getSize());
        Page<UserPO> data=userService.findUserList(page,requestData.getLike());
        return new ResponseEntity<Object>( data, HttpStatus.OK );
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody @Valid AddUserData addUserData, BindingResult bind)
    {
        if(bind.hasErrors()){
           return new ResponseEntity<>( ErrorHandler.GetError( bind ),HttpStatus.OK);
        }
        else{
            boolean result=userDataMgmt.AddUser( addUserData);
            Map<String,Object> ret=new HashMap<>();
            ret.put("result",result);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "edit",method = RequestMethod.PUT)
    public ResponseEntity<?> editUser(@RequestBody @Valid UserPO userPO){
        ResponseEntity<?> responseEntity=null;
        return responseEntity;
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@RequestParam(value = "userId",required = true) int userId){
       ResponseEntity<?> responseEntity=null;
       boolean result=userDataMgmt.DeleteUser(userId);
       Map<String,Object> ret=new HashMap<>();
       ret.put("result",result);
       responseEntity=new ResponseEntity<>(ret,HttpStatus.OK);
       return responseEntity;
    }

    @RequestMapping(value = "login_check",method=RequestMethod.POST)
    public ResponseEntity<?> checkUser(@RequestBody LoginCheckData data){
        ResponseEntity<?> responseEntity=null;
        String retMsg="";
        boolean ret=userDataMgmt.CheckUser( data.getUsername()); //check the username
        if(!ret){
            retMsg=userDataMgmt.getMsg();
        }
        else{
            ret=userDataMgmt.CheckUserAndPassWord(data);
            if(!ret){
                retMsg=userDataMgmt.getMsg();
            }
        }
        Map<String,Object> map=new HashMap<>( );
        map.put("result",ret);
        map.put("retmsg",retMsg);
        responseEntity=new ResponseEntity<>(map,HttpStatus.OK);
        return responseEntity;
    }
}
