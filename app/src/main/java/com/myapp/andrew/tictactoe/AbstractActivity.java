package com.myapp.andrew.tictactoe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.knetikcloud.model.UserResource;

public abstract class AbstractActivity extends AppCompatActivity {

    protected UserResource user;
    protected TicTacToe app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        app = (TicTacToe)getApplicationContext();
        user = app.getUser();

        _onCreate(savedInstanceState);
    }

    protected abstract void _onCreate(@Nullable Bundle savedInstanceState);
}