package com.example.projektgalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import galgeleg.Galgelogik;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    galgeleg.Galgelogik galgelogik;
    Button guessBtn;
    EditText guessField;
    TextView guessedLetters;
    TextView gameWord;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        guessBtn = (Button) findViewById(R.id.guessBtn);
        galgelogik = new Galgelogik();
        guessField = (EditText) findViewById(R.id.guessField);
        guessedLetters = (TextView) findViewById(R.id.guessedLetters);
        gameWord = (TextView) findViewById(R.id.gameWord);
        gameWord.setText(galgelogik.getSynligtOrd());
        guessBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}