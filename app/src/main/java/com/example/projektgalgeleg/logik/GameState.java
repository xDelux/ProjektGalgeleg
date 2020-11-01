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
        hangman.isWon = true;
        for (int n = 0; n < hangman.word.length(); n++) {
            String letter = hangman.word.substring(n, n + 1);
            if (hangman.usedLetters.contains(letter)) {
                hangman.visibleWord = hangman.visibleWord + letter;
            } else {
                hangman.visibleWord = hangman.visibleWord + "*";
                hangman.isWon = false;
            }
        }
        if(hangman.isWon)
            hangman.setHangState(hangman.getGameOverState());
    }

    @Override
    public void guessLetter(String letter) {
        if (letter.length() != 1) return;
        if (hangman.usedLetters.contains(letter)) return;
        if (hangman.isWon || hangman.isLost) {
            hangman.setHangState(hangman.getGameOverState());
            return;
        }

        hangman.usedLetters.add(letter);
        if(!hangman.word.contains(letter)) {
        hangman.totalWrong++;
            if (hangman.totalWrong > 6) {
                hangman.isLost = true;
                hangman.setHangState(hangman.getGameOverState());
            }
        }
        updateWordVisibilty();
    }

    @Override
    public void calculateScore() {

    }

}
