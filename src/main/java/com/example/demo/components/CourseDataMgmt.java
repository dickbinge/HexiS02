package com.example.demo.components;

import com.example.demo.entities.AddCourseData;
import com.example.demo.entities.EditCourseData;
import com.example.demo.model.CoursePO;
import com.example.demo.service.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseDataMgmt {
    @Autowired
    CourseRepository courseRepository;
    public Boolean AddCourse(AddCourseData addCourseData){
        Boolean result=false;
        try{
            CoursePO poNew=new CoursePO();
            poNew.setName(addCourseData.getName());
            poNew.setCno(addCourseData.getCno());
            poNew.setDescription( addCourseData.getDescription() );
            poNew.setCount( addCourseData.getCount() );
            poNew.setCurCount( addCourseData.getCurCount() );
            poNew.setRequired( addCourseData.isRequired());
            courseRepository.save( poNew );
            result=true;
        }
        catch (Exception ex){ex.printStackTrace();}
        return result;
    }

    public Boolean EditCourse(EditCourseData editData){
        Boolean result=false;
        try{
            CoursePO coursePO=courseRepository.findOneByCno(editData.getCno());
            CoursePO poNew=new CoursePO();
            poNew.setId(coursePO.getId());
            poNew.setName( coursePO.getName() );
            poNew.setCno(coursePO.getCno());
            poNew.setCount( editData.getCount() );
            poNew.setCurCount( editData.getCurCount() );
            poNew.setRequired( editData.isRequired() );
            poNew.setDescription(editData.getDescription());
            courseRepository.save( poNew );
            result=true;
        }
        catch (Exception ex){}
        return result;
    }
}
