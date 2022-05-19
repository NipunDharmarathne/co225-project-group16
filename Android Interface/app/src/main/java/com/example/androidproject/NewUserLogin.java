package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidproject.models.Student;
import com.example.androidproject.net.RetrofitService;
import com.example.androidproject.net.StudentServices;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewUserLogin extends AppCompatActivity {

    private Button back;
    private Button next;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_login);

        back = (Button) findViewById(R.id.backBtn);
        next = (Button) findViewById(R.id.nxtBtn);
        submit = (Button) findViewById(R.id.stdSubBtn);

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
        StudentServices studentServices = retrofitService.getRetrofit().create(StudentServices.class);

        submit.setOnClickListener(view -> {
//             long studentRegNo = Long.parseLong(String.valueOf(editTestRegNo.getText()));
//             String studentFirstName = String.valueOf(editTestFirstName.getText());
//             String studentLastName = String.valueOf(editTestLastName.getText());
//             String studentUsername = String.valueOf(editTestNewUsername.getText());
//             String studentPassword = String.valueOf(editTestNewPassword.getText());
// //            int studentCurrentSemester = Integer.parseInt(String.valueOf(editTestUniversity.getText()));
// //            boolean hasStudentRegistered = Boolean.parseBoolean(String.valueOf(editTestDepartment.getText()));
             Student student = new Student();
//             student.setRegNo(studentRegNo);
//             student.setFirstName(studentFirstName);
//             student.setLastName(studentLastName);
//             student.setUsername(studentUsername);
//             student.setPassword(studentPassword);

            studentServices.createStudent(student).enqueue(new Callback<Student>() {
                @Override
                public void onResponse(Call<Student> call, Response<Student> response) {
                    Toast.makeText(NewUserLogin.this, "Save Successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Student> call, Throwable t) {
                    Toast.makeText(NewUserLogin.this, "Save Failed!!!", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(NewUserLogin.class.getName()).log(Level.SEVERE, "Error Occurred", t);
                }
            });

            studentServices.createStudent(student).enqueue(new Callback<Student>() {
                @Override
                public void onResponse(Call<Student> call, Response<Student> response) {
                    Toast.makeText(NewUserLogin.this, "Save Successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Student> call, Throwable t) {
                    Toast.makeText(NewUserLogin.this, "Save Failed!!!", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(NewUserLogin.class.getName()).log(Level.SEVERE, "Error Occurred", t);
//                        Search 'logcat' with "Error Occurred" -> update AndroidManifest.xml with <application ***android:usesCleartextTraffic="true***>"
                }
            });

            });
    }

    private void backPage(){
        Intent intent = new Intent (NewUserLogin.this, MainActivity.class);
        startActivity(intent);
    }

    private void nextPage(){
        Intent intent = new Intent (NewUserLogin.this, StdResultsCalc.class);
        startActivity(intent);
    }
}