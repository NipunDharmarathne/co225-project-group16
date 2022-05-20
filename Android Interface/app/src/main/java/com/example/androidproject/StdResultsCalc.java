package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StdResultsCalc extends AppCompatActivity {

    private Button CurrentGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_results_calc);

        CurrentGPA = (Button) findViewById(R.id.button1);

        CurrentGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCurrentGPA();
            }
        });


    }

    private void openCurrentGPA(){
        Intent intent = new Intent(StdResultsCalc.this, com.example.androidproject.CurrentGPA.class);
        startActivity(intent);
    }
}