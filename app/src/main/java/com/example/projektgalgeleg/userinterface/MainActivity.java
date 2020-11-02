package com.example.projektgalgeleg.userinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import com.example.projektgalgeleg.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent i;
    Button playBtn;
    Button settingBtn;
    Button highscoresBtn;
    String difficulty;
    Bundle bundle;
    RelativeLayout homelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        playBtn = findViewById(R.id.playBtn);
        settingBtn =  findViewById(R.id.settingBtn);
        highscoresBtn = findViewById(R.id.highscoreBtn);

        homelayout = findViewById(R.id.homelayout);


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
                Intent i = getIntent();
                if(i != null) {
                    difficulty = i.getStringExtra("difficulty");
                    bundle = new Bundle();
                    bundle.putString("difficulty", difficulty);
                    fragment = new GameFragment();
                    fragment.setArguments(bundle);
                } else {
                    Log.d("MainActivity", "Difficulty was null");
                    fragment = new GameFragment();
                }
                break;
            case R.id.settingBtn:
                fragment = new GameSettingsFragment();
                break;
            case R.id.highscoreBtn:
                fragment = new HighscoreFragment();
                break;

        }
        homelayout.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        homelayout.setVisibility(View.VISIBLE);
        super.onBackPressed();
    }
}