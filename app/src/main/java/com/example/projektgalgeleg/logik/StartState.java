package com.example.projektgalgeleg.logik;

public class StartState implements GalgeState {
    @Override
    public void stateAction(GalgeContext context) {

        context.setGalgeState(this);
    }
}
