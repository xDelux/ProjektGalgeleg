package com.example.projektgalgeleg.userinterface;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.GameState;
import com.example.projektgalgeleg.logik.Hangman;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GameFragment extends Fragment implements View.OnClickListener {

    Hangman Game;
    Button guessBtn;
    EditText guessField;
    TextView guessedLetters;
    TextView gameWord;
    TextView title;
    TextView score;
    ImageView galgePicture;
    String input;
    String difficulty;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        try {
            difficulty = getArguments().getString("difficulty");
            Game = new Hangman();
            switch (difficulty) {
                case "Let" :
                    Game.setDifficulty(1);
                    break;
                case "Mellem" :
                    Game.setDifficulty(2);
                    break;
                case "Svær" :
                    Game.setDifficulty(3);
                    break;
            }

        } catch (NullPointerException e) {
            Log.d("GameFragment", "Difficulty was null");
            Game = new Hangman();
        }



        guessBtn = view.findViewById(R.id.guessBtn);
        guessField = view.findViewById(R.id.guessField);
        guessedLetters = view.findViewById(R.id.guessedLetters);
        gameWord = view.findViewById(R.id.gameWord);
        title = view.findViewById(R.id.mainGameTitle);
        score = view.findViewById(R.id.highscoreTxt);
        galgePicture = view.findViewById(R.id.galgePicture);

        Game.startNewGame();
        gameWord.setText(Game.getVisibleWord());

        guessBtn.setOnClickListener(this);

        return view;
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
                score.setText("0");
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
            Game.calculateScore();
            title.setText("Du tablte. Din score blev: " + Game.getScore());
            score.setText("" + Game.getScore());
            guessBtn.setText("Genstart");

        } else if(Game.isWon()) {
            Game.calculateScore();
            title.setText("Du Vandt! Vil du køre videre for en højere score?");
            score.setText("" + Game.getScore());
            guessBtn.setText("Genstart");

        }


    }
}
