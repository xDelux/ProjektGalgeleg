package com.example.projektgalgeleg.userinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.Hangman;

public class LostActivity extends AppCompatActivity {

    Button lostendBtn, tryAgainBtn;
    TextView title;
    MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        tryAgainBtn = (Button) findViewById(R.id.tryagainBtn);
        lostendBtn = (Button) findViewById(R.id.lostEndBtn);
        title = findViewById(R.id.lostTitleTxt);

        title.setText("Du table. Ordet var: " + Hangman.getInstance().getWord());

        tryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), GameActivity.class);
                startActivity(i);
            }
        });

        lostendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}