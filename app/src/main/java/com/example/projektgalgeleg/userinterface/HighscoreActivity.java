package com.example.projektgalgeleg.userinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.projektgalgeleg.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

public class HighscoreActivity extends AppCompatActivity {


    public static final String SHARED_PREFS = "shared_prefs";
    public static final String HIGHSCORE = "highscore";
    public static final String NAME = "name";
    public static final String DIFF = "diff";
    SharedPreferences sp;
    ArrayList<HighscoreItem> scores;
    ListView lstV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        // getSharedPreferences(SHARED_PREFS, 0).edit().clear().commit(); // Rydder shared prefs
        loadData();

        lstV = findViewById(R.id.highscoresList);
        sp = getSharedPreferences("args", Context.MODE_PRIVATE);
        Intent i = getIntent();

        Log.d("intent info", i.getStringExtra(NAME) + " "  + i.getStringExtra(DIFF) + " " + i.getStringExtra(HIGHSCORE));

        HighscoreItem item = new HighscoreItem(i.getStringExtra(NAME), i.getStringExtra(DIFF), i.getStringExtra(HIGHSCORE));
        if(i.getStringExtra(NAME) != null) {
            scores.add(item);
        }
        HighscoreArrayAdapter arrayAdapter = new HighscoreArrayAdapter(this, R.layout.adapter_view_highscore_layout, scores);
        lstV.setAdapter(arrayAdapter);
        saveData();
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences. Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(scores);
        editor.putString("highscore_list", json);
        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("highscore_list", null);
        Type type = new TypeToken<ArrayList<HighscoreItem>>() {}.getType();
        scores = gson.fromJson(json, type);

        if(scores == null)
            scores = new ArrayList<>();

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}