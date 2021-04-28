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

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("Result");
        String likeResult = numbersList.get(0);
//        String categoryId = numbersList.get(1);
        TextView likes = findViewById(R.id.likes);
        likes.setText("Predicted Likes are: " + likeResult);
        ImageButton back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
    }
}