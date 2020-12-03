package com.application.subjects.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "User")
public class UserModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String nameUser;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<SubjectModels> subjects;
    
    public Double getAverage(){
        if(subjects.isEmpty()){
            return 0.0;
        }else{
            return this.subjects.stream().mapToDouble(aSubject-> aSubject.getQualification()).sum() / subjects.size();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SubjectModels> getSubjects() {
        return this.subjects;
    }

    public void addSubject(SubjectModels subject) {
        this.subjects.add(subject);
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
