package com.example.gridmaster;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RecentGame {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String playerOneName;
    private String playerTwoName;
    private String playerTwoImage;
    private String mode;
    private String winner;

    public RecentGame(String playerOneName, String playerTwoName, String playerTwoImage, String mode, String winner) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.playerTwoImage = playerTwoImage;
        this.mode = mode;
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public String getPlayerTwoImage() {
        return playerTwoImage;
    }

    public void setPlayerTwoImage(String playerTwoImage) {
        this.playerTwoImage = playerTwoImage;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
