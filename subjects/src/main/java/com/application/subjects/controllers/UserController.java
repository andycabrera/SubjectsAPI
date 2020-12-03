package com.application.subjects.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.application.subjects.models.SubjectModels;
import com.application.subjects.models.UserModels;
import com.application.subjects.services.UserService;
import com.application.subjects.tools.Tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<UserModels> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public UserModels saveUser(@RequestBody UserModels user){
        return userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") Long id){
        Optional<UserModels> user = userService.findById(id);
        if(!user.isPresent()){
            return new Tools().notFound(id);
        }else{
            return ResponseEntity.ok(user.get());
        }

    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

    @GetMapping(path = "/{id}/subjects")
    public ResponseEntity<Object> getSubjects(@PathVariable("id") Long id){
        Optional<UserModels> user = userService.findById(id);
        if(!user.isPresent()){
            return new Tools().notFound(id);
        }else{
            return ResponseEntity.ok(user.get().getSubjects());
        }
    }

    @PostMapping(path = "/{id}/subjects")
    public ResponseEntity<Object> addSubject(@PathVariable("id") Long id, @RequestBody SubjectModels subject){
        Optional<UserModels> user = userService.findById(id);
        if(!user.isPresent()){
            return new Tools().notFound(id);

        }
        userService.addSubject(subject, user.get());
        return ResponseEntity.ok(user);
    }

    @GetMapping(path = "/{id}/average")
    public ResponseEntity<Object> getAverage(@PathVariable("id") Long id){
        Optional<UserModels> user = userService.findById(id);
        if(!user.isPresent()){
            return new Tools().notFound(id);
        }else{
            Map<String, Double> average = new HashMap<String,Double>();
            average.put("average", userService.getAverage(user.get()));
            return ResponseEntity.ok(average);
        }
    }
}
