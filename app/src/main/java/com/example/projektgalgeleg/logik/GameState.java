package com.example.projektgalgeleg.logik;

import java.util.ArrayList;

public class GameState implements HangState {

    Hangman hangman = Hangman.getInstance();

    @Override
    public void createWordList(int difficulty) {

    }

    @Override
    public void startNewGame() {

    }

    @Override
    public void updateWordVisibilty() {
        hangman.visibleWord = "";
        for (int n = 0; n < hangman.word.length(); n++) {
            String letter = hangman.word.substring(n, n + 1);
            if (hangman.usedLetters.contains(letter)) {
                hangman.visibleWord = hangman.visibleWord + letter;
            } else {
                hangman.visibleWord = hangman.visibleWord + "*";
            }
        }
    }

    @Override
    public void guessLetter(String letter) {

    }

    @Override
    public ArrayList<String> getUsedLetters() {
        return null;
    }

    @Override
    public String getVisible() {
        return null;
    }

    @Override
    public boolean isGameWon() {
        return false;
    }

    @Override
    public boolean isGameLost() {
        return false;
    }
}
