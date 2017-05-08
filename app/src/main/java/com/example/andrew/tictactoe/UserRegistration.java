package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.knetikcloud.api.AccessTokenApi;
import com.knetikcloud.api.UsersApi;
import com.knetikcloud.api.UtilSecurityApi;
import com.knetikcloud.client.ApiException;
import com.knetikcloud.model.OAuth2Resource;
import com.knetikcloud.model.TokenDetailsResource;
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
                UsersApi apiInstance = new UsersApi();
                apiInstance.setBasePath(getString(R.string.baseurl));
                UserResource userResource = new UserResource();
                userResource.setUsername(username);
                userResource.setPassword(password);
                userResource.setEmail(email);
                try {
                    UserResource result = apiInstance.registerUser(userResource);
                    System.out.println(result);

                    //Attempts to retrieve token for the new user
                    AccessTokenApi apiInstance2 = new AccessTokenApi();
                    apiInstance2.setBasePath(getString(R.string.baseurl));
                    try {
                        OAuth2Resource result2 = apiInstance2.getOAuthToken(getString(R.string.grant_type), getString(R.string.client_id),
                                null, username, password);
                        System.out.println("User token: " + result2.getAccessToken());

                        //Attempts to retrieve userId using the user's token
                        UtilSecurityApi apiInstance3 = new UtilSecurityApi();
                        apiInstance3.setBasePath(getString(R.string.baseurl));
                        apiInstance3.addHeader("Authorization", "bearer " + result2.getAccessToken());
                        try {
                            TokenDetailsResource result3 = apiInstance3.getUserTokenDetails();
                            System.out.println(result3);
                            userId = result3.getUserId();
                        }
                        catch (ApiException e) {
                            System.err.println("Exception when calling UtilSecurityApi#getUserTokenDetails");
                            e.printStackTrace();
                        }
                    }
                    catch (Exception e) {
                        System.err.println("Exception when calling AccessTokenApi#getOAuthToken");
                        e.printStackTrace();
                    }
                    UserRegistration.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            registrationSuccess();
                        }
                    });
                } catch (Exception e) {
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
        bundle.putString("error", "register");
        ErrorDialog dialog = new ErrorDialog();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }
}
