package com.example.projektgalgeleg.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


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
    }
}