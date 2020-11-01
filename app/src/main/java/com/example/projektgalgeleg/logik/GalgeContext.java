package com.example.projektgalgeleg.logik;

public class GalgeContext {
    private GalgeState galgeState;
    boolean gameRunning;

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
}
