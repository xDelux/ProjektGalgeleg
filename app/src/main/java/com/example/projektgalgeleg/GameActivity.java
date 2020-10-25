package com.example.projektgalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.ArrayList;

import galgeleg.Galgelogik;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    int antalFejl;
    galgeleg.Galgelogik galgelogik;
    Button guessBtn;
    Button restartBtn;
    Button backBtn;
    EditText guessField;
    ArrayList<String> guessedLetters;
    TextView gameWord;
    TextView guessed;
    TextView title;
    ImageView galgePicture;
    String str;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        guessBtn = (Button) findViewById(R.id.guessBtn);
        backBtn = (Button) findViewById(R.id.guessBtn);
        galgelogik = new Galgelogik();
        guessField = (EditText) findViewById(R.id.guessField);
        guessed = findViewById(R.id.guessedLetters);
        gameWord = (TextView) findViewById(R.id.gameWord);
        title = (TextView) findViewById(R.id.mainGameTitle);
        galgePicture = (ImageView) findViewById(R.id.galgePicture);
        guessedLetters = new ArrayList<>();

        gameWord.setText(galgelogik.getSynligtOrd());
        guessBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(galgelogik.erSpilletVundet() || galgelogik.erSpilletTabt()) {
            galgelogik.startNytSpil();
            gameWord.setText(galgelogik.getSynligtOrd());
            guessedLetters.clear();
            guessed.setText("");
            title.setText("Så kører vi igen!");
            galgePicture.setImageResource(R.drawable.galge);
            guessBtn.setText("Gæt");
            return;
        }

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
        update();
        }






    private void update() {
        if(galgelogik.erSpilletVundet()) {
            gameWord.setText(galgelogik.getSynligtOrd());
            title.setText("Du har vundet! Godt gættet!");
            guessBtn.setText("Genstart");
        }
        else if(galgelogik.erSpilletTabt()) {
            gameWord.setText(galgelogik.getSynligtOrd());
            title.setText("Du table, ordet var. " + galgelogik.getOrdet());
            guessBtn.setText("Genstart");
        }

        antalFejl = galgelogik.getAntalForkerteBogstaver();
        switch (antalFejl) {
            case 1:
                galgePicture.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                galgePicture.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                galgePicture.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                galgePicture.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                galgePicture.setImageResource(R.drawable.forkert5);
                break;
            case 6:
                galgePicture.setImageResource(R.drawable.forkert6);
                break;
        }

    }
}