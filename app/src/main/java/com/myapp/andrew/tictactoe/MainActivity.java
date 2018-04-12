package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.UserResource;
import com.myapp.andrew.tictactoe.util.JsapiCall;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Called when "Sign in" button is clicked
    public void userLogin(View view) {

        /***********
         * AUTHENTICATION
         */
        EditText usernameField = (EditText) findViewById(R.id.username);
        EditText passwordField = (EditText) findViewById(R.id.password);

        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        // OAUTH IS HANDLED BY THE SDK AUTOMATICALLY
        ApiClient client = ApiClients.getUserClientInstance(getApplicationContext(), username, password);

        // Attempt to retrieve userID using the userToken
        UsersApi apiInstance = client.createService(UsersApi.class);

        JsapiCall<UserResource> task = new JsapiCall<UserResource>(this, this::loginSuccess, t -> ApiClients.resetUserClientInstance());

        task.setTitle("Authenticating");
        task.setMessage("Verifying credentials...");

        task.execute(apiInstance.getUser("me"));
    }

    public void loginSuccess(UserResource user) {

        ((TicTacToe)getApplicationContext()).setUser(user);

        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    //Called when "Register" button is clicked
    public void openUserRegistration(View view) {
        Intent intent = new Intent(this, UserRegistration.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //dont allow it
    }
}