package com.eshanazora.focus;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.json.JSONObject;


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
        //changing color
        ConstraintLayout constraintLayout = findViewById(R.id.container);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
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
        motivationMode = findViewById(R.id.quotes);

        motivationMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motivationActivity();
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
//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.start();
//        quote = findViewById(R.id.quotes);
//        // Instantiate the RequestQueue.
//        //Request a string response from the provided URL.
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
//                "https://quote-garden.herokuapp.com/quotes/random", null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                // Display the first 500 characters of the response string.
//                try {
//                    System.out.println(response.getString("quoteText"));
//                    quote.setText("Response is: " + response.getString("quoteText"));
//                } catch (Exception e) {}
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                quote.setText("No quote today.");
//            }
//        });
//        //Add the request to the RequestQueue.
//        queue.add(request);
        startActivity(motivation);
    }
}
