package com.example.projektgalgeleg.userinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projektgalgeleg.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (Button) findViewById(R.id.playBtn);
        settingBtn = (Button) findViewById(R.id.settingBtn);
        exitBtn = (Button) findViewById(R.id.exitBtn);
        playBtn.setOnClickListener(this);
        settingBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v == playBtn) {
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);
        }
        else if (v == settingBtn) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        }
        else if (v == exitBtn) {

        }
    }
}