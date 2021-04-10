package com.example.youtubepredictor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.ybq.android.spinkit.SpinKitView
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        activeServer()
    }

    private fun moveToNextScreen() {
        val spinKitView = findViewById<SpinKitView>(R.id.spin_kit)

        spinKitView.visibility = View.GONE
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
        finish()
    }


    private fun activeServer () {
        val textView = findViewById<TextView>(R.id.text)
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://youtube-predictor.herokuapp.com/"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    moveToNextScreen()
                }, Response.ErrorListener {
                textView.visibility = View.VISIBLE
                textView.text = "Something went Wrong"
        })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}