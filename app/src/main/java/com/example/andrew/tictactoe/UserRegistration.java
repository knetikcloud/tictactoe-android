package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.TextProperty;
import com.knetikcloud.model.UserResource;

public class UserRegistration extends AppCompatActivity {
    String adminToken;
    String username;
    String password;
    String email;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        adminToken = getIntent().getExtras().getString("adminToken");
    }
    //Called when "Register" button is clicked
    public void registerUser(View view) {
        EditText usernameField = (EditText) findViewById(R.id.username);
        EditText passwordField = (EditText) findViewById(R.id.password);
        EditText emailField = (EditText) findViewById(R.id.email);
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
        email = emailField.getText().toString();

        //Attempts to register a new user using the inputted information
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient defaultClient = Configuration.getDefaultApiClient();
                defaultClient.setBasePath(getString(R.string.baseurl));

                // Configure OAuth2 access token for authorization: OAuth2
                OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                OAuth2.setAccessToken(adminToken);

                UserResource userResource = new UserResource();
                userResource.setUsername(username);
                userResource.setPassword(password);
                userResource.setEmail(email);

                // Setting the default avatar
                ImageProperty imageProperty = new ImageProperty();
                imageProperty.setType("image");
                imageProperty.setUrl("http://i.imgur.com/7VgKD2j.jpg");
                userResource.putAdditionalPropertiesItem("avatar", imageProperty);

                //Setting the default gamePieceColor
                TextProperty textProperty = new TextProperty();
                textProperty.setType("text");
                textProperty.setValue(getString(R.string.black));
                userResource.putAdditionalPropertiesItem("gamePieceColor", textProperty);

                UsersApi apiInstance = new UsersApi();
                try {
                    UserResource result = apiInstance.registerUser(userResource);
                    System.out.println(result);

                    userId = result.getId();
                    System.out.println("userId: " + userId);

                    UserRegistration.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            registrationSuccess();
                        }
                    });
                }
                catch (Exception e) {
                    UserRegistration.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            registrationError();
                        }
                    });
                    System.err.println("Exception when calling UsersApi#registerUser");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void registrationSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void registrationError() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "register");
        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }
}
