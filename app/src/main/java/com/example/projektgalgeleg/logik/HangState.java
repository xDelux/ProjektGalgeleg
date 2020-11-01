package com.example.projektgalgeleg.logik;

import java.util.ArrayList;

public interface HangState {

    void createWordList(int difficulty);
    void startNewGame();
    void updateWordVisibilty();
    void guessLetter(String letter);
    ArrayList<String> getUsedLetters();
    String getVisible();

}
