package com.example.demo.service;

import com.example.demo.model.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private  UserRepository userRepository;
    public Page<UserPO> findUserList(Pageable page,String like){
        if(like!=null||like.trim().length()!=0){
            return userRepository.findByLike(like,page);
        }else{
            return userRepository.findAllUser(page);
        }
    }
}
