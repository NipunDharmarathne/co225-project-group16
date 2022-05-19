package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewAdminLogin extends AppCompatActivity {

    private Button back;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_admin_login);

        back = (Button) findViewById(R.id.BckBtn);
        next = (Button) findViewById(R.id.NxtBtn);

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