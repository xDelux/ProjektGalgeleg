package com.example.projektgalgeleg.logik;

import java.util.ArrayList;

public class GameState implements HangState {

    private static GameState gameStateInstance = null;

    public static GameState getInstance() {
        if(gameStateInstance == null)
            gameStateInstance = new GameState();
        return gameStateInstance;
    }

    @Override
    public void createWordList(Hangman hangman, int difficulty) {

    }

    @Override
    public void startNewGame(Hangman hangman, int difficulty) {

    }

    @Override
    public void updateWordVisibilty(Hangman hangman) {
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
            hangman.setHangState(GameOverState.getInstance());
    }

    @Override
    public void guessLetter(Hangman hangman, String letter) {
        if (letter.length() != 1) return;
        if (hangman.usedLetters.contains(letter)) return;
        if (hangman.isWon || hangman.isLost) {
            hangman.setHangState(GameOverState.getInstance());
            return;
        }

        hangman.usedLetters.add(letter);
        if(!hangman.word.contains(letter)) {
        hangman.totalWrong++;
            if (hangman.totalWrong > 6) {
                hangman.isLost = true;
                hangman.setHangState(GameOverState.getInstance());
            }
        }
        updateWordVisibilty(hangman);
    }

    @Override
    public void calculateScore(Hangman hangman) {


    }

}
