package com.lendingcatalog.model;

import java.time.LocalDate;

public class Game {
    private LocalDate date;
    private Team team1;
    private Team team2;
    private int team1Score;
    private int team2Score;

    public Game(LocalDate date, Team team1, Team team2, int team1Score, int team2Score) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString (){
        String s = date + " " + team1 + " " + team1Score + " " + team2 + " " + team2Score;
        return s;
    }

}
