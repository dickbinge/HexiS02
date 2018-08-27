package com.example.demo.entities;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorHandler {
    public static Object GetError(BindingResult result){
        List<ErrorMessage> listError=new ArrayList<>(  );
        if(result.hasErrors()){
           List<ObjectError> errors=result.getAllErrors();
           for(ObjectError error:errors){
               FieldError errorField=(FieldError)(error);
               ErrorMessage message=new ErrorMessage();
               message.setField( errorField.getField() );
               message.setDefaultMessage( error.getDefaultMessage() );
               listError.add(message);
           }
       }
        if(listError.size()>0){ //has error
            Map<String,Object> ret=new HashMap<>();
            ret.put("FieldError",listError);
            return ret;
        }
        else{
            return null;
        }
    }
}
