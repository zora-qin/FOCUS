package com.eshanazora.focus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class goalsActivity extends AppCompatActivity {
    private Button menu;
    private Button add;
    private EditText addGoals;
    //private ListView goalsList;
    private ArrayList<String> goals = new ArrayList<>();
    private LinearLayout forChunk;
    private CheckedTextView newGoals;
    private CheckBox checkBox;
    //private ArrayAdapter<String> adapter;

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
        //goalsList = findViewById(R.id.goalsList);
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,goals);
        //goalsList.setAdapter(adapter);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGoals = findViewById(R.id.setGoals);
                String g = addGoals.getText().toString();
                if (!g.equals("")) {
                    goals.add(g);
                    addGoals.setText("");
                    updateGoalsUI();
                }
            }
        });
    }
    public void updateGoalsUI() {
        forChunk = findViewById(R.id.forChunk);
        forChunk.removeAllViews();
        for (String s : goals) {
            View chunk = getLayoutInflater().inflate(R.layout.chunk_goals, forChunk, false);
            checkBox = chunk.findViewById(R.id.checkBox);
            s= addGoals.getText().toString();
            checkBox.setText(s);
            forChunk.addView(chunk);
        }
    }

    public void MainActivity() {
        Intent backToMenu = new Intent(this, MainActivity.class);
        startActivity(backToMenu);
    }
}
