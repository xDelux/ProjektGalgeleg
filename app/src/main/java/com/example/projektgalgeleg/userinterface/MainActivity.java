package com.example.projektgalgeleg.userinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.Context;
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
    Fragment settingsFragment = new GameSettingsFragment();
    Fragment highscoreFragment = new HighscoreFragment();
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
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.playBtn:
                try {
                    Hangman.getInstance().setPlayerName(playername.getText().toString());
                    if(Hangman.getInstance().getPlayerName().matches(""))
                        throw new NullPointerException();
                    fragment = new GameFragment();
                } catch (NullPointerException e) {
                    playername.setError("Indtast dit navn");
                    return;
                }
                break;
            case R.id.settingBtn:
                fragment = settingsFragment;
                Hangman.freeInstance();
                break;
            case R.id.highscoreBtn:
                fragment = highscoreFragment;

                break;

        }
        homelayout.setVisibility(View.GONE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        homelayout.setVisibility(View.VISIBLE);
        super.onBackPressed();
    }
}