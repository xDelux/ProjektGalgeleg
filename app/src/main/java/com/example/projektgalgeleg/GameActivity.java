package com.example.projektgalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.ArrayList;

import galgeleg.Galgelogik;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    galgeleg.Galgelogik galgelogik;
    Button guessBtn;
    EditText guessField;
    ArrayList<String> guessedLetters;
    TextView gameWord;
    TextView guessed;
    TextView title;
    String str;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        guessBtn = (Button) findViewById(R.id.guessBtn);
        galgelogik = new Galgelogik();
        guessField = (EditText) findViewById(R.id.guessField);
        guessed = findViewById(R.id.guessedLetters);
        gameWord = (TextView) findViewById(R.id.gameWord);
        title = (TextView) findViewById(R.id.mainGameTitle);
        guessedLetters = new ArrayList<>();



        gameWord.setText(galgelogik.getSynligtOrd());

        guessBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        guessField.setError(null);
        str = guessField.getText().toString();

        if(str.equals(galgelogik.getOrdet())) {
            char c;
            for (int i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                galgelogik.gætBogstav(Character.toString(c));
            }
            update();
            return;
        }

        if(str.length() != 1) {
            guessField.setError("Maks ét bogstav");
            return;
        }

        galgelogik.gætBogstav(str);


        if(!guessedLetters.contains(str)) {
            guessedLetters.add(str);
            guessed.append(str + ", ");
            gameWord.setText(galgelogik.getSynligtOrd());

        }
        else {
            guessField.setError("Du har gættet på " + str);
            return;
        }

    }
    private void update() {
        if(galgelogik.erSpilletVundet()) {
            gameWord.setText(galgelogik.getSynligtOrd());
            title.setText("Du har vundet!");
        }
        else if(galgelogik.erSpilletTabt()) {
            gameWord.setText(galgelogik.getSynligtOrd());
            title.setText("Du table, ordet var. " + galgelogik.getOrdet());
        }
    }
}