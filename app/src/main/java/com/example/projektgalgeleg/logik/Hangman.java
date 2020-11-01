package com.example.projektgalgeleg.logik;
import java.util.ArrayList;

public class Hangman {

    private static Hangman hangmanInstance = null;

    HangState startState;
    HangState gameState;
    HangState idleState;
    HangState gameOverState;

    private HangState hangState;
    boolean gameRunning;
    boolean isWon;
    boolean isLost;
    int difficulty;
    ArrayList<String> wordList;
    ArrayList<String> usedLetters;
    int totalWrong;
    String word;
    String visibleWord;


    private Hangman() {

        startState = new StartState();
        gameState = new GameState();
        gameOverState = new GameOverState();

        hangState = startState;
    }

    public static Hangman getInstance() {
        if(hangmanInstance == null)
            hangmanInstance = new Hangman();

        return hangmanInstance;
    }

    // Getter and Setter's for the States
    public void setHangState(HangState hangState) {
        this.hangState = hangState;
    }
    public HangState getHangState() {
        return hangState;
    }
    public HangState getStartState() { return startState; }
    public HangState getGameState() { return gameState; }
    public HangState getIdleState() { return idleState; }
    public HangState getGameOverState() { return gameOverState; }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }


    public void createWordList(int difficulty) {
        hangState.createWordList(difficulty);
    }
    public void startNewGame() {
        hangState.startNewGame();
    }
    public void updateWordVisibilty() {}
    public void guessLetter(String letter) {
        hangState.guessLetter(letter);
    }
    public ArrayList<String> getUsedLetters() {
        return hangState.getUsedLetters();
    }
    public String getVisible() {
        return hangState.getVisible();
    }

    public int getTotalWrong() {
        return totalWrong;
    }
    public boolean isPreviousCorrect() {}
    public boolean isGameWon() {}
    public boolean isGameLost() {}
    public boolean isGameOver() {}
    public void createWordList() {}

    public void setWordListD1() {
        wordList.add("bil");
        wordList.add("tyve");
        wordList.add("mis");
        wordList.add("gave");
        wordList.add("næse");
        wordList.add("is");
        wordList.add("tag");
    }
    public void setWordListD2() {
        wordList.add("solhangman.sort");
        wordList.add("skovsnegl");
        wordList.add("gangsti");
        wordList.add("busrute");
        wordList.add("motorvej");
        wordList.add("computer");
        wordList.add("elastik");
        wordList.add("madlavning");
    }
    public void setWordListD3() {
        wordList.add("programmering");
        wordList.add("firehundrede");
        wordList.add("dimplomingeniør");
        wordList.add("androidudvikler");
        wordList.add("pikantelope");
        wordList.add("politianmeldelse");
        wordList.add("fuckhvorerjegliderlig");
        wordList.add("klorhexedin");
        wordList.add("bankrøveri");
        wordList.add("quizmaster");
        wordList.add("zebratæmmer");
        wordList.add("sanseudvikler");
    }


}
