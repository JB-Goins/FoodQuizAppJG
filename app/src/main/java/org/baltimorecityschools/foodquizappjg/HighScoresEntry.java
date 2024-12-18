package org.baltimorecityschools.foodquizappjg;

public class HighScoresEntry {
    private String name;
    private int score;


    public HighScoresEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public HighScoresEntry(){
        name = "";
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScores() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScores(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "HighScoresEntry{" +
                "name='" + name + '\'' +
                ", scores=" + score +
                '}';
    }
}
