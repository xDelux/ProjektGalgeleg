package com.example.projektgalgeleg.logik;

import java.util.ArrayList;

public interface HangState {

    void createWordList(Hangman hangman, int difficulty);
    void startNewGame(Hangman hangman, int difficulty);
    void updateWordVisibilty(Hangman hangman);
    void guessLetter(Hangman hangman, String letter);
    void calculateScore(Hangman hangman);


}
