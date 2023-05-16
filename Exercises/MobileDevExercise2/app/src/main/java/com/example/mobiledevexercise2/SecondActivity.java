package com.example.mobiledevexercise2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (getIntent().hasExtra("Hey")) {
            TextView tv = findViewById(R.id.textView);
            String text = getIntent().getExtras().getString("Hey");
            tv.setText(text);
        }

    }
}