package com.example.gofmaven.AOP;

public class StudentRepository {
    private StudentData studentData = new StudentData();
    public void save(StudentData studentData){
        this.studentData = studentData;
    }
}
