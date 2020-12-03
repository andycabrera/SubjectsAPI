package com.application.subjects.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Tools {
    
    public Tools(){}

    public ResponseEntity<Object> notFound(Long id){
        Map<String, String> error = new HashMap<String,String>();
        error.put("error", "The User with id: "+id+ " has not been found." );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
