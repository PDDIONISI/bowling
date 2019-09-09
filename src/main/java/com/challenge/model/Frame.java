package com.challenge.model;

public class Frame {
    private int frameNumber;
    private String firstRoll;
    private String secondRoll;
    private String extraRoll;
    private int score;
    private boolean strike;
    private boolean spare;

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
        this.firstRoll = "0";
        this.secondRoll = "0";
        this.extraRoll = "0";
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public String getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(String firstRoll) {
        this.firstRoll = firstRoll;
    }

    public String getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(String secondRoll) {
        this.secondRoll = secondRoll;
    }

    public String getExtraRoll() {
        return extraRoll;
    }

    public void setExtraRoll(String extraRoll) {
        this.extraRoll = extraRoll;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }
}
