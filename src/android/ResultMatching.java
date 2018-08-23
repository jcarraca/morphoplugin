package com.jcarraca.cordova.plugin;

public class ResultMatching {
    private int matchingPKNumber;
    private int matchingScore;

    public int getMatchingScore() {
        return this.matchingScore;
    }

    public void setMatchingScore(int matchingScore) {
        this.matchingScore = matchingScore;
    }

    public int getMatchingPKNumber() {
        return this.matchingPKNumber;
    }

    public void setMatchingPKNumber(int matchingPKNumber) {
        this.matchingPKNumber = matchingPKNumber;
    }
}
