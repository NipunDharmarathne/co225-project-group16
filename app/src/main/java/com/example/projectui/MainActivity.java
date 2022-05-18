package com.example.projectui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projectui.CourseRegistration;
import com.example.projectui.NewUserLogin;
import com.example.projectui.Student;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private TextView info;
    private Button adminLogin;
    private Button stdLogin;
    private Button newUser;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.Password);
        info = (TextView) findViewById(R.id.attemptsNo);
        adminLogin = (Button) findViewById(R.id.AdminButton);
        stdLogin = (Button) findViewById(R.id.StdButton);
        newUser = (Button) findViewById(R.id.NewUserBtn);

        info.setText("No of attempts remaining: 5");

        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminValidate(userName.getText().toString(), password.getText().toString());
            }
        });

        stdLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stdValidate(userName.getText().toString(), password.getText().toString());
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewUserForum();
            }
        });

    }

    private void adminValidate(String userName, String userPwd){
        if ((userName.equals("Admin")) && (userPwd.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, CourseRegistration.class);
            startActivity(intent);

        } else {
            counter--;
            info.setText("No of attempts remaining: " + String.valueOf(counter));
            if (counter <= 0){
                adminLogin.setEnabled(false);
            }
        }
    }

    private void stdValidate(String userName, String userPwd){
        if ((userName.equals("Std")) && (userPwd.equals("5678"))){
            Intent intent = new Intent(MainActivity.this, Student.class);
            startActivity(intent);

        } else {
            counter--;
            info.setText("No of attempts remaining: " + String.valueOf(counter));
            if (counter <= 0){
                stdLogin.setEnabled(false);
            }
        }
    }

    private void openNewUserForum(){
        Intent intent = new Intent (MainActivity.this, NewUserLogin.class);
        startActivity(intent);
    }
}