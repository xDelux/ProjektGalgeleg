package com.example.projektgalgeleg.userinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.Hangman;

public class WonActivity extends AppCompatActivity {

    Button endBtn, goBtn;
    TextView score;
    MainActivity main;
    SharedPreferences sp;
    int counter;
    String playername;
    public static final String SHARED_PREFS = "shared_prefs";
    public static final String HIGHSCORE = "highscore";
    public static final String NAME = "name";
    public static final String DIFF = "diff";

    Hangman hgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);
        hgm  = Hangman.getInstance();

        score = findViewById(R.id.scoreTxt);
        goBtn = findViewById(R.id.goBtn);
        endBtn = findViewById(R.id.wonEndBtn);

        score.setText("" + Hangman.getInstance().getScore());

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), GameActivity.class);
                startActivity(i);
            }
        });

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Her skal der sendes info til highscore listen
                Intent highscoreIntent = new Intent(v.getContext(), HighscoreActivity.class);
                highscoreIntent.putExtra(NAME, hgm.getPlayerName());
                highscoreIntent.putExtra(HIGHSCORE, hgm.getScore() );
                highscoreIntent.putExtra(DIFF, hgm.getDifficulty() );
                startActivity(highscoreIntent);
            }
        });

    }

}