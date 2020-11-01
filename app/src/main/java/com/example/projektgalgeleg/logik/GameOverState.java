package com.example.projektgalgeleg.logik;

import java.util.ArrayList;
import java.util.Random;

public class GameOverState implements HangState {

    Hangman hangman = Hangman.getInstance();

    @Override
    public void createWordList(int difficulty) {

    }

    @Override
    public void startNewGame() {
        hangman.totalWrong = 0;
        hangman.usedLetters.clear();
        hangman.word = hangman.wordList.get(new Random().nextInt(hangman.wordList.size()));
        if(hangman.isLost) {
            hangman.Score = 0;
            hangman.isLost = false;
        }
        else {

        }
        updateWordVisibilty();
        hangman.setHangState(hangman.getGameState());
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
    public void calculateScore() {
        hangman.Score += hangman.difficulty * 100 * hangman.word.length() * ((10 - hangman.totalWrong) * 0.1);
    }


}
