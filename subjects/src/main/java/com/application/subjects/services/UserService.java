package com.application.subjects.services;

import java.util.ArrayList;
import java.util.Optional;

import com.application.subjects.models.SubjectModels;
import com.application.subjects.models.UserModels;
import com.application.subjects.respositories.SubjectReposity;
import com.application.subjects.respositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SubjectReposity subjectReposity;

    public ArrayList<UserModels> getUsers(){
        return (ArrayList<UserModels>) userRepository.findAll();
    }

    public UserModels saveUser(UserModels user){
        return userRepository.save(user);
    }

    public Optional<UserModels> findById(Long id){
        return userRepository.findById(id);
    }

    public String deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return "Se ha eliminado correctamente";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public UserModels addSubject(SubjectModels subject, UserModels user){
        subject.setUser(user);
        subjectReposity.save(subject);
        user.addSubject(subject);
        return userRepository.save(user);
    }

    public Double getAverage(UserModels user){
        return user.getAverage();
    }
}
