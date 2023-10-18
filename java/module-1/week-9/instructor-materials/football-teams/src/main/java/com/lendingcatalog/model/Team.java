package com.lendingcatalog.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String city;
    private String mascot;
    private String coach;

    private List<Game> games;

    public Team(String city, String mascot, String coach) {
        this.city = city;
        this.mascot = mascot;
        this.coach = coach;
        this.games = new ArrayList<>();
    }

    public String getCity() {
        return city;
    }

    public String getMascot() {
        return mascot;
    }

    public String getCoach() {
        return coach;
    }

    public List<Game> getGames() {
        return games;
    }

    public String toString() {
        String s = city + " " + mascot;
        return s;
    }
}
