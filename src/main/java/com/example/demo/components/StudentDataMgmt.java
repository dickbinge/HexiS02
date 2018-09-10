package com.example.demo.components;

import com.example.demo.entities.AddStudentData;
import com.example.demo.entities.PostStudentData;
import com.example.demo.model.StudentPO;
import com.example.demo.model.UserPO;
import com.example.demo.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDataMgmt {

    @Autowired
    StudentRepository studentRepository;
    public boolean AddStudentData(AddStudentData data){
        boolean result=false;
        try{
            boolean bfindSame=false;
            StudentPO studentPO=studentRepository.findOneBySno( data.getSno() );
            if(studentPO!=null){
                bfindSame=true;

            }else{
                StudentPO poNew=new StudentPO();
                poNew.setName( data.getName() );
                poNew.setSex( data.getSex() );
                poNew.setAge( data.getAge() );
                poNew.setEmail( data.getEmail() );
                poNew.setSno( data.getSno() );
                poNew.setAddress( data.getAddress() );
                poNew.setProfession( data.getProfession() );
                studentRepository.save( poNew );
                result=true;
            }
        }catch (Exception ex){ }
        return result;
    }

    public boolean EditStudentData(PostStudentData data){
        boolean result=false;
        try{
            StudentPO studentPO=studentRepository.findOneBySno( data.getSno() );
            if(studentPO!=null){
                StudentPO poNew=new StudentPO();
                poNew.setId( studentPO.getId() );
                poNew.setSno( data.getSno() );
                poNew.setName( studentPO.getName() );
                poNew.setSex( data.getSex() );
                poNew.setAge( data.getAge() );
                poNew.setEmail( data.getEmail() );
                poNew.setAddress( data.getAddress() );
                poNew.setProfession( data.getProfession() );
                studentRepository.save( poNew );
                result=true;
            }
        }catch (Exception ex){}
        return result;
    }

    public boolean DeleteStudentData(String sno){
        boolean result=false;
        try{
            StudentPO studentPO=studentRepository.findOneBySno( sno );
            if(studentPO!=null){
                studentRepository.delete( studentPO );
                result=true;
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
