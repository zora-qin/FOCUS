package com.eshanazora.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class motivationActivity extends AppCompatActivity {
    private Button menu;
    private TextView quote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        menu = findViewById(R.id.back);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.start();
        quote = findViewById(R.id.quotes);
        // Instantiate the RequestQueue.
        //Request a string response from the provided URL.
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                "https://quote-garden.herokuapp.com/quotes/random", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Display the first 500 characters of the response string.
                try {
                    quote.setText(response.getString("quoteText") + " - " + response.getString("quoteAuthor"));
                } catch (Exception e) {}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                quote.setText("No quote today.");
            }
        });
        //Add the request to the RequestQueue.
        queue.add(request);
    }
    public void MainActivity() {
        Intent backToMenu = new Intent(this, MainActivity.class);
        startActivity(backToMenu);
    }
}
