package com.rohit.examples.android.clanofwars.model;

import java.util.ArrayList;

public class Team {
    private int id;
    private String team_Title;
    private ArrayList<Player> allPlayersInTeam;

    public Team() {
    }

    public Team(int id, String team_Title, ArrayList<Player> allPlayersInTeam) {
        this.id = id;
        this.team_Title = team_Title;
        this.allPlayersInTeam = allPlayersInTeam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam_Title() {
        return team_Title;
    }

    public void setTeam_Title(String team_Title) {
        this.team_Title = team_Title;
    }

    public ArrayList<Player> getAllPlayersInTeam() {
        return allPlayersInTeam;
    }

    public void setAllPlayersInTeam(ArrayList<Player> allPlayersInTeam) {
        this.allPlayersInTeam = allPlayersInTeam;
    }
}
