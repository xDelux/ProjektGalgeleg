package com.example.projektgalgeleg.userinterface;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.Hangman;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Hangman Game;
    Button guessBtn;
    EditText guessField;
    TextView guessedLetters;
    TextView gameWord;
    TextView title;
    TextView score;
    ImageView galgePicture;
    String input;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        Game = Hangman.getInstance();

        guessBtn = findViewById(R.id.guessBtn);
        guessField = findViewById(R.id.guessField);
        guessedLetters = findViewById(R.id.guessedLetters);
        gameWord = findViewById(R.id.gameWord);
        title = findViewById(R.id.mainGameTitle);
        score = findViewById(R.id.highscoreTxt);
        galgePicture = findViewById(R.id.galgePicture);

        Game.startNewGame();
        gameWord.setText(Game.getVisibleWord());

        guessBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(Game.isWon() || Game.isLost()) {
            Game.startNewGame();
            guessedLetters.setText("");
            gameWord.setText(Game.getVisibleWord());
            title.setText("Galgeleg kører igen!");
            galgePicture.setImageResource(R.drawable.galge);
            guessBtn.setText("Gæt");
            if(Game.isLost())
                score.setText("" + score);
            return;
        }

        input = guessField.getText().toString();
        if(Game.getUsedLetters().contains(input)) {
            guessField.setError("Du har allerede gættet på " + input);
            return;

        } else if(input.length() != 1) {
            guessField.setError("Maks ét bogstav");
            return;
        }
        else {
            guessedLetters.append(input + ", ");
            Game.guessLetter(input);
            gameWord.setText(Game.getVisibleWord());
        }

        switch (Game.getTotalWrong()) {
            case 1 :
                galgePicture.setImageResource(R.drawable.forkert1);
                break;
            case 2 :
                galgePicture.setImageResource(R.drawable.forkert2);
                break;
            case 3 :
                galgePicture.setImageResource(R.drawable.forkert3);
                break;
            case 4 :
                galgePicture.setImageResource(R.drawable.forkert4);
                break;
            case 5 :
                galgePicture.setImageResource(R.drawable.forkert5);
                break;
            case 6 :
                galgePicture.setImageResource(R.drawable.forkert6);
                break;
        }

        if(Game.isLost()) {
            Intent i = new Intent(this, LostActivity.class);
            startActivity(i);

        } else if(Game.isWon()) {
            Intent i = new Intent(this, WonActivity.class);
            startActivity(i);
        }
    }


}
