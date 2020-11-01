package com.example.projektgalgeleg.logik;
import java.util.ArrayList;

public class GalgeContext {
    private GalgeState galgeState;
    boolean gameRunning;
    int difficulty;
    ArrayList<String> wordList;

    public GalgeContext(int difficulty) {
        galgeState = new StartState();
        gameRunning = true;
        this.difficulty = difficulty;
    }

    public GalgeContext() {
        galgeState = new StartState();
        gameRunning = true;
    }

    public void setGalgeState(GalgeState galgeState) {
        this.galgeState = galgeState;
    }

    public GalgeState getGalgeState() {
        return galgeState;
    }

    public void createWordList() {
        switch (difficulty) {
            case 1 :
                setWordListD1();
                break;
            case 2 :
                setWordListD2();
                break;
            case 3 :
                setWordListD3();
                break;
        }
    }

    private void setWordListD1() {
        wordList.add("bil");
        wordList.add("tyve");
        wordList.add("mis");
        wordList.add("gave");
        wordList.add("næse");
        wordList.add("is");
        wordList.add("tag");
    }

    private void setWordListD2() {
        wordList.add("solsort");
        wordList.add("skovsnegl");
        wordList.add("gangsti");
        wordList.add("busrute");
        wordList.add("motorvej");
        wordList.add("computer");
        wordList.add("elastik");
        wordList.add("madlavning");
    }

    private void setWordListD3() {
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
