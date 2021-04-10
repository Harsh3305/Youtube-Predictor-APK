package com.example.youtubepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Home extends AppCompatActivity {

    private Button submit;
    private EditText categoryId;
    private EditText view_count;
    private EditText video_count;
    private EditText subscriber_count;
    private EditText video_title;
    private EditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        submit= findViewById(R.id.button);
        categoryId = findViewById(R.id.categoryId);
        view_count = findViewById(R.id.view_count);
        video_count = findViewById(R.id.video_count);
        subscriber_count = findViewById(R.id.subscriber_count);
        video_title = findViewById(R.id.video_titile);
        description = findViewById(R.id.description);

//        RequestQueue requestQueue;

        // Instantiate the cache
//        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
//
//        // Set up the network to use HttpURLConnection as the HTTP client.
//        Network network = new BasicNetwork(new HurlStack());
//
//        // Instantiate the RequestQueue with the cache and network.
//        requestQueue = new RequestQueue(cache, network);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_text = categoryId.getText().toString();

                String view_count_text = view_count.getText().toString();

                String video_count_text = video_count.getText().toString();

                String subscriber_count_text = subscriber_count.getText().toString();

                String video_title_text = video_count.getText().toString();

                String description_text = description.getText().toString();

                fetchData(id_text, view_count_text, video_count_text, subscriber_count_text, video_title_text, description_text);
            }
        });



    }

    public void fetchData (String id_tex, String view_count_text, String video_count_text, String subscriber_count_text, String video_title_text, String description_text) {

        String url = "https://youtube-predictor.herokuapp.com/categoryId/"+id_tex +"/view_count/"+view_count_text+"/video_count/"+ video_count_text+"/subscriber_count/"+ subscriber_count_text +"/video_titile/"+ video_title_text+"/description/" + description_text;
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String text = response.getString("likes");
                            Intent i = new Intent(Home.this, Result.class);
                            i.putExtra("likes", text);
                            startActivity(i);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(Home.this, "Some error occure", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(Home.this, "Some error occure", Toast.LENGTH_LONG).show();
                    }
                });

        queue.add(jsonObjectRequest);
    }

}