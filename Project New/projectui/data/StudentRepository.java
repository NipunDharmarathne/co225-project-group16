package com.example.projectui.data;

import com.example.projectui.models.Student;
import com.example.projectui.net.StudentServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StudentRepository {

    Gson gson = new GsonBuilder()
            .setDateFormat("dd-MM-yyyy")
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("localhost:8080/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    StudentServices service;

    public StudentRepository() {
        service = retrofit.create(StudentServices.class);
    }

    public void getAllStudents() {
        service.listStudent();
    }

    public void createStudent(Student newStudent) {
        service.createStudent(newStudent);
    }

    public void deleteStudent(long regNo) {
        service.deleteStudent(regNo);
    }

    public void updateStudent(long regNo, Student student) {
        service.updateStudent(regNo, student);
    }
/*    public void getAllStudents(Callback<List<Student>> callback) {
        service.listStudent().enqueue(callback);
    }

    public void createStudent(Student newStudent, Callback<Student> callback) {
        service.createStudent(newStudent).enqueue(callback);
    }

    public void deleteStudent(long regNo, Callback<Object> callback) {
        service.deleteStudent(regNo).enqueue(callback);
    }

    public void updateStudent(long regNo, Student student, Callback<Student> callback) {
        service.updateStudent(regNo, student).enqueue(callback);
    }*/
}
