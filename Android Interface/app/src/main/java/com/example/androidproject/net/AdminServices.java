package com.example.androidproject.net;

import com.example.androidproject.models.Admin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AdminServices {
    @GET("/admin")
    Call<List<Admin>> listAdmin();

    @POST("/admin/create")
    Call<Admin> createAdmin(@Body Admin admin);

    @PUT("/admin/update/{id}")
    Call<Admin> updateAdmin(@Path("regNo") long RegNo, @Body Admin admin);

    @DELETE("/admin/delete/{id}")
    Call<Object> deleteAdmin(@Path("regNo") long RegNo);
}
