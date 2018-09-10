package com.example.demo.components;

import com.example.demo.entities.AddUserData;
import com.example.demo.entities.LoginCheckData;
import com.example.demo.model.StudentPO;
import com.example.demo.model.UserPO;
import com.example.demo.service.StudentRepository;
import com.example.demo.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataMgmt {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;
    public boolean AddUser(AddUserData addUserData)
    {
        boolean result=false;
        try{
            List<UserPO> existList=userRepository.findAll();
            boolean bfindSame=false;
            for(UserPO exist :existList) //检查当前数据库中存储的用户名是否重名
            {
                if(exist.getName().equals( addUserData.getName()))
                {
                    bfindSame=true;
                    break;
                }
            }
            if(!bfindSame)
            {
                UserPO poNew=new UserPO();
                StudentPO student=studentRepository.findOneBySno(addUserData.getSno()); //通过输入的学号去查询其他信息
                poNew.setName( addUserData.getName() );
                poNew.setPassword( addUserData.getPassword());
                poNew.setEmail( addUserData.getEmail() );
                poNew.setSno( student.getSno());
                student.setId(student.getId());
                student.setName(student.getName());
                student.setSno(student.getSno());
                poNew.setStudent(student);
                userRepository.save( poNew );
                result=true;
            }
        }catch (Exception ex){}
        return result;
    }

    public boolean DeleteUser(int userId){
        boolean result=false;
        try{
            UserPO userPO=userRepository.findOne( userId );
            if(userPO!=null){
                userRepository.delete( userId );
                result=true;
            }
        }catch (Exception ex){
            result=false;
        }
        return result;
    }

    public boolean CheckUser(String userName){
        boolean result=false;
        try{
            UserPO userPO=userRepository.findOneByName(userName);
            if(userPO!=null){
                result=true;
            }else{
                setMsg("用户名错误");
            }
        }catch (Exception ex){}
        return result;
    }

    public boolean CheckUserAndPassWord(LoginCheckData data){
        boolean result=false;
        try{
            UserPO userPO=userRepository.findOneByNameAndPassword( data.getUsername(),data.getPassword() );
            if(userPO!=null){
                result=true;
            }else{
                setMsg( "密码错误!" );
            }
        }catch (Exception ex){}
        return result;
    }
}
