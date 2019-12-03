package com.eshanazora.focus;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {
    //main activity;
    private Button studyMode;
    private Button goalsMode;
    private Button motivationMode;
    private TextView quote;
    public static String INTERNET;

    private static final String study = "Study for an hour.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        //initializations
        //main activities
        studyMode = findViewById(R.id.study);
        studyMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studyActivity();
            }
        });
        goalsMode = findViewById(R.id.goal);
        goalsMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goalsActivity();
            }
        });
        motivationMode = findViewById(R.id.quote);
        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url ="https://quote-garden.herokuapp.com/quotes/random";

        motivationMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motivationActivity();
                //send a request
               quote = findViewById(R.id.quote);
                // Instantiate the RequestQueue.
// Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                quote.setText("Response is: "+ response.substring(0,500));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        quote.setText("That didn't work!");
                    }
                });

// Add the request to the RequestQueue.
                queue.add(stringRequest);

            }
        });
    }
    public void studyActivity() {
        Intent goStudy = new Intent(this, studyActivity.class);
        startActivity(goStudy);
    }
    public void goalsActivity() {
        Intent checkGoals = new Intent(this, goalsActivity.class);
        startActivity(checkGoals);
    }
    public void motivationActivity() {
        Intent motivation = new Intent(this, motivationActivity.class);
        startActivity(motivation);
    }


}
