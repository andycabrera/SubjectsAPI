package com.application.subjects.respositories;

import com.application.subjects.models.SubjectModels;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectReposity extends CrudRepository<SubjectModels, Long>{

}
