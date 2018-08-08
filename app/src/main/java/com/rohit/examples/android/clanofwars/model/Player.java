package com.rohit.examples.android.clanofwars.model;

import java.util.ArrayList;

public class Player {
    private int id;
    private String playerTitle;
    private int playerImage;
    private String levelText;

    public Player() {
    }

    public Player(int id, int playerImage, String playerTitle, String levelText) {
        this.id = id;
        this.playerTitle = playerTitle;
        this.playerImage = playerImage;
        this.levelText = levelText;
    }

    public int getId() {
        return id;
    }

    public int getPlayerImage() {
        return playerImage;
    }

    public String getPlayerTitle() {
        return playerTitle;
    }

    public String getLevelText() {
        return levelText;
    }
}
