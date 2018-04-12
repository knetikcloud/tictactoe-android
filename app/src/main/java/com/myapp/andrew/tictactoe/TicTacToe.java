package com.myapp.andrew.tictactoe;

import android.app.Application;

import com.knetikcloud.model.UserResource;

public class TicTacToe extends Application {

    private UserResource user;

    public void setUser(UserResource user) {
        this.user = user;
    }

    public UserResource getUser() {
        return user;
    }
}
