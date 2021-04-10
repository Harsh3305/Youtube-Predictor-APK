package com.example.youtubepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String result = intent.getExtras().getString("likes");


        TextView likes = findViewById(R.id.likes);

        likes.setText(result);

        ImageButton back = findViewById(R.id.back);

        back.setOnClickListener(v -> finish());


    }
}