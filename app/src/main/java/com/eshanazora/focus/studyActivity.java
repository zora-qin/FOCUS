package com.eshanazora.focus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class studyActivity extends AppCompatActivity {
    //study mode;
    private TextView timerText;
    private Button start;
    private Button menu;
    private CountDownTimer countDownTimer;
    private long timeLeft = 3600000; // 10 mins
    private TextView neverStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        //study mode;
        timerText = findViewById(R.id.timer);
        start = findViewById(R.id.start);
        menu = findViewById(R.id.back);
        neverStop = findViewById(R.id.neverstop);
        //start counting down
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer();
            }
        });
        //back to menu
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
                MainActivity();
            }
        });
    }
    public void MainActivity() {
        Intent backToMenu = new Intent(this, MainActivity.class);
        startActivity(backToMenu);
    }
    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTimer();
            }
            @Override
            public void onFinish() {
                timerText.setText("Success!");
            }
        }.start();
        start.setText("FOCUS");
        neverStop.setVisibility(View.VISIBLE);
//        timerRunning = true;
    }
    public void stopTimer() {
        countDownTimer.cancel();
//        timerRunning = false;
    }
    public void updateTimer() {
        int minutes = (int) timeLeft / 60000;
        int seconds = (int) timeLeft % 60000 / 1000;
        String timerLeftText;
        timerLeftText = "" + minutes;
        timerLeftText += ":";
        if (seconds < 10) timerLeftText += "0";
        timerLeftText += seconds;

        timerText.setText(timerLeftText);
    }
}
