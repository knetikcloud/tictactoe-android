package com.example.andrew.tictactoe;

/**
 * Created by Andrew on 5/3/2017.
 */

public class GamePlayedEvent {

    int userId;

    Boolean victory;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Boolean getVictory() {
        return victory;
    }

    public void setVictory(Boolean victory) {
        this.victory = victory;
    }
}
