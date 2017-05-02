package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.knetikcloud.api.AccessTokenApi;
import com.knetikcloud.model.OAuth2Resource;
import com.squareup.okhttp.MediaType;


public class MainActivity extends AppCompatActivity {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void userLogin(View view) {
        EditText usernameField = (EditText) findViewById(R.id.username);
        EditText passwordField = (EditText) findViewById(R.id.password);
        final String username = usernameField.getText().toString();
        final String password = passwordField.getText().toString();


    }

    public void openUserRegistration(View view) {
        Intent intent = new Intent(this, UserRegistration.class);
        startActivity(intent);
    }
}