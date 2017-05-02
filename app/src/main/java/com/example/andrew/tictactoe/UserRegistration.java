package com.example.andrew.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.knetikcloud.api.AccessTokenApi;
import com.knetikcloud.model.OAuth2Resource;

public class UserRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
    }

    public void registerUser(View view) {
        EditText usernameField = (EditText) findViewById(R.id.username);
        EditText passwordField = (EditText) findViewById(R.id.password);
        EditText emailField = (EditText) findViewById(R.id.email);
        final String username = usernameField.getText().toString();
        final String password = passwordField.getText().toString();
        final String email = emailField.getText().toString();


    }
}
