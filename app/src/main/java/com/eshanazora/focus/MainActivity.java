package com.eshanazora.focus;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        startActivity(motivation);
    }


}
