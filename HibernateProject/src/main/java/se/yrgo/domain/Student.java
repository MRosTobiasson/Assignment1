package se.yrgo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;


    public Student() {}
    
    public Student(String name, String enrollmentID) {
    	this.name = name;
        this.enrollmentID = enrollmentID;
    }
    public int getId() {
    	return id;
    }

}