package com.example.youtubepredictor;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private EditText view_count;
    private EditText video_count;
    private EditText subscriber_count;
    private EditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton submit = findViewById(R.id.NextButton);
        view_count = findViewById(R.id.total_views);
        video_count = findViewById(R.id.video_count);
        subscriber_count = findViewById(R.id.subscriber_count);
        EditText video_title = findViewById(R.id.video_titile);
        description = findViewById(R.id.description);



        submit.setOnClickListener(v -> {

            String view_count_text = view_count.getText().toString();

            String video_count_text = video_count.getText().toString();

            String subscriber_count_text = subscriber_count.getText().toString();

            String video_title_text = video_title.getText().toString();

            String description_text = description.getText().toString();

            if (view_count_text.isEmpty() || video_count_text.isEmpty() || subscriber_count_text.isEmpty() || description_text.isEmpty() || video_title_text.isEmpty() || description_text.isEmpty()) {
                Toast.makeText(Home.this, "Invalid Input", Toast.LENGTH_LONG).show();
            }
            else {

                ArrayList<String> transfer = new ArrayList<>();
                transfer.add(view_count_text);
                transfer.add(video_count_text);
                transfer.add(subscriber_count_text);
                transfer.add(video_title_text);
                transfer.add(description_text);

                Intent intent = new Intent(Home.this, Category.class);
                intent.putExtra("storeData", transfer);
                startActivity(intent);
            }
        });
    }

}