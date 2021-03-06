package com.example.demo.controller;

import com.example.demo.components.StudentDataMgmt;
import com.example.demo.controller.apiData.FindStudentEntity;
import com.example.demo.controller.apiData.PageModel;
import com.example.demo.entities.AddStudentData;
import com.example.demo.entities.ErrorHandler;
import com.example.demo.entities.PostStudentData;
import com.example.demo.model.StudentPO;
import com.example.demo.model.UserPO;
import com.example.demo.service.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1.0/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired private StudentDataMgmt studentDataMgmt;
    @Autowired private StudentService studentService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<?> getStudentList(){
        ResponseEntity<?> responseEntity=null;
        try {
            List<StudentPO> list = studentRepository.findAll();
            PageModel pageModel=new PageModel();
            pageModel.setData( list );
            pageModel.setTotalCount( list.size() );
            responseEntity=new ResponseEntity<>(pageModel,HttpStatus.OK);
        }catch (Exception ex){
            responseEntity = new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public ResponseEntity<?> findStudent(@RequestBody @Valid FindStudentEntity entity,BindingResult bind){
        if(bind.hasErrors()){
            return new ResponseEntity<>(ErrorHandler.GetError(bind),HttpStatus.OK);
        }else {
            Pageable pageable = new PageRequest(entity.getPage(),entity.getSize());
            return new ResponseEntity<Object>(studentService.findStudent(pageable,entity.getLike(),entity.getSex()),HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<?> addStudentData(@RequestBody @Valid AddStudentData data, BindingResult bind){
        if(bind.hasErrors()){
            return new ResponseEntity<>( ErrorHandler.GetError( bind ),HttpStatus.OK);
        }else {
            ResponseEntity<?> responseEntity = null;
            boolean result = studentDataMgmt.AddStudentData( data );
            Map<String, Object> ret = new HashMap();
            ret.put( "result", result );
            responseEntity = new ResponseEntity<>( ret, HttpStatus.OK );
            return responseEntity;
        }
    }

    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public ResponseEntity<?> editStudentData(@RequestBody @Valid PostStudentData data,BindingResult bind){
        ResponseEntity<?> responseEntity=null;
        if(bind.hasErrors()){
            return new ResponseEntity<>( ErrorHandler.GetError( bind ),HttpStatus.OK);
        }else {
            boolean result = studentDataMgmt.EditStudentData( data );
            Map<String, Object> ret = new HashMap<>();
            ret.put( "result", result );
            responseEntity = new ResponseEntity<>( ret, HttpStatus.OK );
        }
        return responseEntity;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudent(@RequestParam String sno)
    {
        ResponseEntity<?> responseEntity=null;
        try {
            boolean result=studentDataMgmt.DeleteStudentData(sno);
            Map<String,Object> retMap=new HashMap<>();
            retMap.put("result",result);
            responseEntity=new ResponseEntity<>(retMap,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return responseEntity;
    }
}
