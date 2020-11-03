package com.example.projektgalgeleg.logik;

import java.util.ArrayList;
import java.util.Random;

public class StartState implements HangState {

    private static StartState startStateInstance = null;

    public static StartState getInstance() {
        if(startStateInstance == null)
            startStateInstance = new StartState();
        return startStateInstance;
    }

    @Override
    public void createWordList(Hangman hangman, int difficulty) {
        switch (difficulty) {
            case 1 :
                hangman.setWordListD1();
                break;
            case 2 :
                hangman.setWordListD2();
                break;
            case 3 :
                hangman.setWordListD3();
        }
    }

    @Override
    public void startNewGame(Hangman hangman, int difficulty) {
        createWordList(hangman, difficulty);
        if (hangman.wordList.isEmpty()) throw new IllegalStateException("Listen over mulige ord er tom!");
        hangman.word = hangman.wordList.get(new Random().nextInt(hangman.wordList.size()));
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

    }

}
