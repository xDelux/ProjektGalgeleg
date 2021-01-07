package com.example.projektgalgeleg.userinterface;

public class HighscoreItem {

    private String navn;
    private String score;
    private String sværhedsgrad;

    public HighscoreItem(String navn, String score, String sværhedsgrad) {
        this.navn = navn;
        this.score = score;
        this.sværhedsgrad = sværhedsgrad;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSværhedsgrad() {
        return sværhedsgrad;
    }

    public void setSværhedsgrad(String sværhedsgrad) {
        this.sværhedsgrad = sværhedsgrad;
    }


}
