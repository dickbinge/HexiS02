package com.example.demo.controller;

import com.example.demo.components.CourseDataMgmt;
import com.example.demo.controller.apiData.PageModel;
import com.example.demo.controller.apiData.PostCourse;
import com.example.demo.entities.AddCourseData;
import com.example.demo.entities.EditCourseData;
import com.example.demo.entities.ErrorHandler;
import com.example.demo.model.CoursePO;
import com.example.demo.service.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("v1.0/course")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseService courseService;
    @Autowired
    CourseDataMgmt courseDataMgmt;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<?> getList(){
        ResponseEntity<?> responseEntity=null;
        try{
            List<CoursePO> list=courseRepository.findAll();
            PageModel model=new PageModel();
            model.setTotalCount( list.size() );
            model.setData( list );
            responseEntity=new ResponseEntity<>(model, HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity = new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public ResponseEntity<?> findList(@RequestBody @Valid PostCourse course, BindingResult bind){
        if(bind.hasErrors()){
            return new ResponseEntity<>( ErrorHandler.GetError( bind),HttpStatus.OK);
        }
        else{
            Pageable pageable=new PageRequest(course.getPage(),course.getSize());
            return new ResponseEntity<Object>(courseService.findCourse( pageable,course.getLike(),course.getIsCur()),HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<?> addCourse(@RequestBody @Valid AddCourseData addCourseData,BindingResult bind){
        if(bind.hasErrors()){
            return new ResponseEntity<Object>(ErrorHandler.GetError( bind ),HttpStatus.OK);
        }
        else{
            ResponseEntity<?> responseEntity=null;
            HashMap<String,Object> map=new HashMap<>( );
            map.put("result",courseDataMgmt.AddCourse( addCourseData ));
            responseEntity=new ResponseEntity<Object>( map,HttpStatus.OK );
            return responseEntity;
        }
    }

    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity<?> editCourse(@RequestBody @Valid EditCourseData editData,BindingResult bind){
        if(bind.hasErrors()){
            return new ResponseEntity<Object>( ErrorHandler.GetError( bind ),HttpStatus.OK );
        }
        else{
            ResponseEntity<?> responseEntity=null;
            HashMap<String,Object> map=new HashMap<>();
            map.put("result",courseDataMgmt.EditCourse( editData ));
            responseEntity=new ResponseEntity<Object>( map,HttpStatus.OK );
            return responseEntity;
        }
    }
}
