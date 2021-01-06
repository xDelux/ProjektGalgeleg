package com.example.projektgalgeleg.userinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;


import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.Hangman;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button playBtn;
    Button settingBtn;
    Button highscoresBtn;
    String difficulty;
    EditText playername;
    RelativeLayout homelayout;
    SharedPreferences sp;
    ArrayList<String> highscores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.playBtn);
        settingBtn =  findViewById(R.id.settingBtn);
        highscoresBtn = findViewById(R.id.highscoreBtn);
        homelayout = findViewById(R.id.homelayout);
        playername = findViewById(R.id.playernameET);

        playBtn.setOnClickListener(this);
        settingBtn.setOnClickListener(this);
        highscoresBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        System.out.println(difficulty);
        Intent i = null;
        switch (v.getId()) {
            case R.id.playBtn:
                try {
                    Hangman.getInstance().setPlayerName(playername.getText().toString());
                    if(Hangman.getInstance().getPlayerName().matches(""))
                        throw new NullPointerException();
                    i = new Intent(this, GameActivity.class);
                } catch (NullPointerException e) {
                    playername.setError("Indtast dit navn");
                    return;
                }
                break;
            case R.id.settingBtn:
                i = new Intent(this, GameSettingsActivity.class);
                Hangman.freeInstance();
                break;
            case R.id.highscoreBtn:
                i  = new Intent(this, HighscoreActivity.class);

                break;

        }
        startActivity(i);
    }

}