package com.example.mobiledevexercise2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSecondActivity = findViewById(R.id.btnSecondActivity);
        Button buttonGoogle = findViewById(R.id.btnGoogle);
        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(),SecondActivity.class);
                startIntent.putExtra("Hey","Hello!");
                startActivity(startIntent);
            }
        });
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "http://www.google.com";
                Uri webaddress = Uri.parse(google);
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (goToGoogle.resolveActivity(getPackageManager())!=null) {
                    startActivity(goToGoogle);
                }
            }
        });
    }
}