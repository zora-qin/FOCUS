package com.eshanazora.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class goalsActivity extends AppCompatActivity {
    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        menu = findViewById(R.id.back);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity();
            }
        });
    }
    public void MainActivity() {
        Intent backToMenu = new Intent(this, MainActivity.class);
        startActivity(backToMenu);
    }
}
