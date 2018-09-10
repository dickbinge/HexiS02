package com.example.demo.service;

import com.example.demo.controller.apiData.PostCourse;
import com.example.demo.model.CoursePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired CourseRepository courseRepository;
    public Page<CoursePO> findCourse(Pageable pageable,String like,String isCur){
        if(like.trim().length()!=0){
            if(isCur.trim().length()!=0){
                Boolean required=Boolean.valueOf( isCur ).booleanValue();
                return courseRepository.findByRequiredAndNameLikeAndCnoLike(required,like,pageable);
            }
            else{
                return courseRepository.findByNameLikeOrCnoLike( pageable,like );
            }
        }
        else{
            if(isCur.trim().length()!=0){
                Boolean required=Boolean.valueOf(isCur).booleanValue();
                return courseRepository.findByRequired( required,pageable );
            }
            else{
                return courseRepository.findByPage(pageable);
            }
        }
    }
}
