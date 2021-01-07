package com.example.projektgalgeleg.logik;

import java.util.ArrayList;
import java.util.Random;

public class GameOverState implements HangState {

    private static GameOverState gameOverStateInstance = null;

    public static GameOverState getInstance() {
        if(gameOverStateInstance == null)
            gameOverStateInstance = new GameOverState();
        return gameOverStateInstance;
    }

    @Override
    public void createWordList(Hangman hangman, int difficulty) {

    }

    @Override
    public void startNewGame(Hangman hangman, int difficulty) {
        hangman.totalWrong = 0;
        hangman.usedLetters.clear();
        hangman.word = hangman.wordList.get(new Random().nextInt(hangman.wordList.size()));
        if(hangman.isLost) {
            hangman.Score = 0;
            hangman.isLost = false;
        }
        else {
            hangman.isWon = false;
        }
        updateWordVisibilty(hangman);
        hangman.setHangState(GameState.getInstance());
    }

    @Override
    public void updateWordVisibilty(Hangman hangman) {
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
    public void guessLetter(Hangman hangman, String letter) {

    }

    @Override
    public void calculateScore(Hangman hangman) {
        if(hangman.difficulty == 4)
            hangman.Score += (hangman.difficulty * 100 * (hangman.word.length() - hangman.totalWrong))/2;
        else
        hangman.Score += hangman.difficulty * 100 * (hangman.word.length() - hangman.totalWrong);
    }


}
