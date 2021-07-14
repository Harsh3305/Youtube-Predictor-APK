package com.example.youtubepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ArrayList<String> transfer = (ArrayList<String>) getIntent().getSerializableExtra("storeData");

        String view_count = transfer.get(0);
        String video_count = transfer.get(1);
        String subscriber_count = transfer.get(2);
        String video_title = transfer.get(3);
        String description = transfer.get(4);

        addButton(view_count, video_count, subscriber_count, video_title, description);
        
    }

    private void addButton(String view_count, String video_count, String subscriber_count, String video_title, String description) {
        Button button = findViewById(R.id._1);
        button.setOnClickListener(v -> Category.this.onClick("1", view_count, video_count, subscriber_count, video_title, description));

        button = findViewById(R.id._2);
        button.setOnClickListener(v -> Category.this.onClick("2", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._10);
        button.setOnClickListener(v -> Category.this.onClick("10", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._15);
        button.setOnClickListener(v -> Category.this.onClick("15", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._17);
        button.setOnClickListener(v -> Category.this.onClick("17", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._18);
        button.setOnClickListener(v -> Category.this.onClick("18", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._19);
        button.setOnClickListener(v -> Category.this.onClick("19", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._20);
        button.setOnClickListener(v -> Category.this.onClick("20", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._21);
        button.setOnClickListener(v -> Category.this.onClick("21", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._22);
        button.setOnClickListener(v -> Category.this.onClick("22", view_count, video_count, subscriber_count, video_title, description));

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        button = findViewById(R.id._23);
        button.setOnClickListener(v -> Category.this.onClick("23", view_count, video_count, subscriber_count, video_title, description));

        button = findViewById(R.id._24);
        button.setOnClickListener(v -> Category.this.onClick("24", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._25);
        button.setOnClickListener(v -> Category.this.onClick("25", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._26);
        button.setOnClickListener(v -> Category.this.onClick("26", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._27);
        button.setOnClickListener(v -> Category.this.onClick("27", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._28);
        button.setOnClickListener(v -> Category.this.onClick("28", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._29);
        button.setOnClickListener(v -> Category.this.onClick("29", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._30);
        button.setOnClickListener(v -> Category.this.onClick("30", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._31);
        button.setOnClickListener(v -> Category.this.onClick("31", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._32);
        button.setOnClickListener(v -> Category.this.onClick("32", view_count, video_count, subscriber_count, video_title, description));

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        button = findViewById(R.id._33);
        button.setOnClickListener(v -> Category.this.onClick("33", view_count, video_count, subscriber_count, video_title, description));

        button = findViewById(R.id._34);
        button.setOnClickListener(v -> Category.this.onClick("34", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._35);
        button.setOnClickListener(v -> Category.this.onClick("35", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._36);
        button.setOnClickListener(v -> Category.this.onClick("36", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._37);
        button.setOnClickListener(v -> Category.this.onClick("37", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._38);
        button.setOnClickListener(v -> Category.this.onClick("38", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._39);
        button.setOnClickListener(v -> Category.this.onClick("39", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._40);
        button.setOnClickListener(v -> Category.this.onClick("40", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._41);
        button.setOnClickListener(v -> Category.this.onClick("41", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._42);
        button.setOnClickListener(v -> Category.this.onClick("42", view_count, video_count, subscriber_count, video_title, description));


        button = findViewById(R.id._43);
        button.setOnClickListener(v -> Category.this.onClick("43", view_count, video_count, subscriber_count, video_title, description));


    }

    public void onClick (String id, String view_count, String video_count, String subscriber_count, String video_title, String description) {
        fetchData(id, view_count, video_count, subscriber_count, video_title, description);
    }

    public void fetchData (String id_tex, String view_count_text, String video_count_text, String subscriber_count_text, String video_title_text, String description_text) {
        final String URL = "https://youtube-predictor.herokuapp.com/PredictLikes";
        Map obj= new HashMap();
        obj.put("categoryId",Integer.parseInt(id_tex));
        obj.put("view_count",Integer.parseInt(view_count_text));
        obj.put("video_count",Integer.parseInt(video_count_text));
        obj.put("subscriber_count", Integer.parseInt(subscriber_count_text));
        obj.put("video_title", video_title_text);
        obj.put("description",description_text);

        String url = "https://flasktut.azurewebsites.net";
//         String url = "https://youtube-predictor.herokuapp.com/PredictLikes";

        JsonObjectRequest request_json = new JsonObjectRequest(URL, new JSONObject(obj),
                response -> {
                    //Process os success response

                    String text = null;
                    try {
                        text = response.getString("likes");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    ArrayList<String> l = new ArrayList<>();
                    l.add(text);
                    l.add(id_tex);
                    Intent intent = new Intent(Category.this, Result.class);
                    intent.putExtra("Result", l);
                    startActivity(intent);
                    finish();
                }, error -> VolleyLog.e("Error: ", error.getMessage()));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request_json);
    }

}
