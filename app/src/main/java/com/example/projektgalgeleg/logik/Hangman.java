package com.example.projektgalgeleg.logik;
import java.util.ArrayList;

public class Hangman {

    private static Hangman gameInstance = null;

    private HangState hangState;
    private HangState startState;
    private HangState gameState;
    private HangState gameOverState;

    double Score;
    boolean isWon;
    boolean isLost;
    int difficulty = 1;

    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<String> usedLetters = new ArrayList<>();
    int totalWrong;
    String word;
    String visibleWord;
    String playerName;


    private Hangman() {
        startState = StartState.getInstance();
        gameState = GameState.getInstance();
        gameOverState = GameOverState.getInstance();
        hangState = startState;
    }

    public static void freeInstance() {
        gameInstance = null;
    }
    public static Hangman getInstance() {
        if(gameInstance == null)
            gameInstance = new Hangman();
        return gameInstance;
    }


    // Getter and Setter's for the States
    public void setHangState(HangState hangState) { this.hangState = hangState; }

    public double getScore() { return Score; }
    public boolean isWon() { return isWon; }
    public boolean isLost() { return isLost; }
    public int getDifficulty() { return difficulty; }
    public ArrayList<String> getWordList() { return wordList; }
    public ArrayList<String> getUsedLetters() { return usedLetters; }
    public int getTotalWrong() { return totalWrong; }
    public String getWord() { return word; }
    public String getVisibleWord() { return visibleWord; }
    public void setDifficulty(int difficulty) { this.difficulty = difficulty; }
    public void setPlayerName(String name) {this.playerName = name; }
    public String getPlayerName() { return playerName; }

    public void createWordList(int difficulty) { hangState.createWordList(this, difficulty); }
    public void startNewGame() { hangState.startNewGame(this, this.difficulty); }
    public void guessLetter(String letter) { hangState.guessLetter(this, letter); }
    public void calculateScore() { hangState.calculateScore(this); }


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
        wordList.add("solsort");
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
        wordList.add("klorhexedin");
        wordList.add("bankrøveri");
        wordList.add("quizmaster");
        wordList.add("zebratæmmer");
        wordList.add("sanseudvikler");
    }


}
