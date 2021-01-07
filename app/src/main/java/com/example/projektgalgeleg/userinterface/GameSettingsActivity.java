package com.example.projektgalgeleg.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.Hangman;

public class GameSettingsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Button confirmBtn;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_settings);

       ListView listView = findViewById(R.id.difficultySpin);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.difficulty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        input = parent.getItemAtPosition(position).toString();
        Hangman Game = Hangman.getInstance();
        Game.setDifficulty(position + 1);
        Log.d("tag", "Sværhedsgraden er nu " + Game.getDifficulty());
        Toast.makeText(getApplicationContext(), "Sværhedsgraden er nu " + parent.getItemAtPosition(Game.getDifficulty()-1), Toast.LENGTH_SHORT).show();
        ScaleAnimation skalaanim = new ScaleAnimation(1, 0.7f, 1, 1.5f, parent.getWidth() / 2, parent.getHeight() / 2);
        skalaanim.setDuration(300);
        skalaanim.setRepeatCount(1); // skalér ind og ud igen
        skalaanim.setRepeatMode(Animation.REVERSE);
        skalaanim.setInterpolator(new DecelerateInterpolator());
        parent.startAnimation(skalaanim);

    }
}