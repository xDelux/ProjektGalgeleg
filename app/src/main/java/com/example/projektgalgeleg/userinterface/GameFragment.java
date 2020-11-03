package com.example.projektgalgeleg.userinterface;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projektgalgeleg.R;
import com.example.projektgalgeleg.logik.Hangman;

import static android.content.Context.MODE_PRIVATE;


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
    SharedPreferences sp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        sp = this.getActivity().getSharedPreferences("args", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();


        Game = Hangman.getInstance();

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
            Fragment lostFragment = new LostFragment();
            this.getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, lostFragment)
                    .addToBackStack(null)
                    .commit();

        } else if(Game.isWon()) {
            Game.calculateScore();
            Fragment wonFragment = new WonFragment();
            this.getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, wonFragment)
                    .addToBackStack(null)
                    .commit();

        }
    }


}
