package com.application.subjects.models;

import javax.persistence.*;

@Entity
@Table(name = "Subject")
public class SubjectModels {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String status;
    private Double qualification;

    @ManyToOne
    private UserModels user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(UserModels user){
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getQualification() {
        return qualification;
    }

    public void setQualification(Double qualification) {
        this.qualification = qualification;
    }

}
