package com.example.demo.service;

import com.example.demo.model.StudentPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired private StudentRepository studentRepository;
    public Page<StudentPO> findStudent(Pageable page, String like, String sex)
    {
        if(sex==null||sex=="")
        {
            if(like.trim().length()==0)
            {
                return studentRepository.findByPage( page );
            }
            else
            {
                return studentRepository.findByLike( like,page );
            }
        }
        else
        {
            if(like.trim().length()==0)
            {
                return studentRepository.findBySex( sex,page );
            }
            else
            {
                return studentRepository.findByLikeAndSex( like,sex,page );
            }
        }
    }

}
