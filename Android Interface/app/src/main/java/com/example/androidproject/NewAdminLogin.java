package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidproject.models.Admin;
import com.example.androidproject.net.RetrofitService;
import com.example.androidproject.net.AdminServices;


import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewAdminLogin extends AppCompatActivity {

    private Button back;
    private Button next;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_admin_login);

        back = (Button) findViewById(R.id.BckBtn);
        next = (Button) findViewById(R.id.NxtBtn);
        submit = (Button) findViewById(R.id.admSbtBtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backPage();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage();
            }
        });

        RetrofitService retrofitService = new RetrofitService();
        AdminServices adminServices = retrofitService.getRetrofit().create(AdminServices.class);

        submit.setOnClickListener(view -> {

            EditText editTestAdmFullName = findViewById(R.id.adminFullName);
            EditText editTestNewAdmUsername =findViewById(R.id.newAdminUserName);
            EditText editTestNewAdmPassword =findViewById(R.id.newAdminPwd);
            EditText editTestAdmDpt =findViewById(R.id.adminDpt);
            EditText editTestAdmFac =findViewById(R.id.adminFaculty);
            EditText editTestAdmUni =findViewById(R.id.adminUniversity);
            EditText editTestAdmRegNo =findViewById(R.id.adminRegNo);
            EditText editTestAdmYear =findViewById(R.id.adminYr);
            EditText editTestTotSubsFirstSem =findViewById(R.id.totSubsFirstSem);
            EditText editTestTotSubsSecondSem =findViewById(R.id.totSubsScndSem);


            long adminRegNo = Long.parseLong(String.valueOf(editTestAdmRegNo.getText()));
            String adminFullName = String.valueOf(editTestAdmFullName.getText());
            String adminUsername = String.valueOf(editTestNewAdmUsername.getText());
            String adminPassword = String.valueOf(editTestNewAdmPassword.getText());
            String adminUniversity = String.valueOf(editTestAdmUni.getText());
            String adminFaculty = String.valueOf(editTestAdmFac.getText());
            String adminDepartment = String.valueOf(editTestAdmDpt.getText());
            long adminYear = Long.parseLong(String.valueOf(editTestAdmYear.getText()));
            long totSubsFirstSem = Long.parseLong(String.valueOf(editTestTotSubsFirstSem.getText()));
            long totSubsSecondSem = Long.parseLong(String.valueOf(editTestTotSubsSecondSem.getText()));

            Admin admin = new Admin();

            admin.setRegNo(adminRegNo);
            admin.setFullName(adminFullName);
            admin.setUsername(adminUsername);
            admin.setPassword(adminPassword);
            admin.setUniversity(adminUniversity);
            admin.setFaculty(adminFaculty);
            admin.setDepartment(adminDepartment);
            admin.setYear(adminYear);
            admin.setTotalSubjectsInFirstSem(totSubsFirstSem);
            admin.setTotalSubjectsInSecondSem(totSubsSecondSem);

            adminServices.createAdmin(admin).enqueue(new Callback<Admin>() {
                @Override
                public void onResponse(Call<Admin> call, Response<Admin> response) {
                    Toast.makeText(NewAdminLogin.this, "Save Successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Admin> call, Throwable t) {
                    Toast.makeText(NewAdminLogin.this, "Save Failed!!!", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(NewAdminLogin.class.getName()).log(Level.SEVERE, "Error Occurred", t);
                }
            });
        });
    }

    private void backPage(){
        Intent intent = new Intent (NewAdminLogin.this, MainActivity.class);
        startActivity(intent);
    }

    private void nextPage(){
        Intent intent = new Intent (NewAdminLogin.this, CourseRegistration.class);
        startActivity(intent);
    }


}