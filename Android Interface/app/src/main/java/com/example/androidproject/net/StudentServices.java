package com.example.androidproject.net;

import com.example.androidproject.models.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface StudentServices {
    @GET("/student")
    Call<List<Student>> listStudent();

    @POST("/student/create")
    Call<Student> createStudent(@Body Student student);

    @PUT("/student/update/{id}")
    Call<Student> updateStudent(@Path("regNo") long RegNo, @Body Student student);

    @DELETE("/student/delete/{id}")
    Call<Object> deleteStudent(@Path("regNo") long RegNo);

}