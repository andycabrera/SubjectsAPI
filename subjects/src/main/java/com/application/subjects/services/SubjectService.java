package com.application.subjects.services;

import com.application.subjects.respositories.SubjectReposity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    SubjectReposity subjectReposity;

}
