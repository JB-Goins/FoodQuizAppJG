package org.baltimorecityschools.foodquizappjg;

public class HighScoresEntry {
    private String name;
    private int scores;

    public HighScoresEntry(String name, int scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public int getScores() {
        return scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
    
}
