package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.knetikcloud.api.AccessTokenApi;
import com.knetikcloud.api.UtilSecurityApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.OAuth2Resource;
import com.knetikcloud.model.TokenDetailsResource;

public class MainActivity extends AppCompatActivity {
    String adminToken;
    String userToken;
    int userId;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates a token with admin privileges on startup
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient defaultClient = Configuration.getDefaultApiClient();
                defaultClient.setBasePath(getString(R.string.baseurl));

                AccessTokenApi apiInstance = new AccessTokenApi();
                try {
                    OAuth2Resource result = apiInstance.getOAuthToken(getString(R.string.grant_type), getString(R.string.client_id),
                            null, getString(R.string.username), getString(R.string.password));
                    adminToken = result.getAccessToken();
                    System.out.println("Admin token: " + adminToken);
                }
                catch (Exception e) {
                    System.err.println("Exception when calling AccessTokenApi#getOAuthToken");
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //Called when "Sign in" button is clicked
    public void userLogin(View view) {
        EditText usernameField = (EditText) findViewById(R.id.username);
        EditText passwordField = (EditText) findViewById(R.id.password);
        username = usernameField.getText().toString();
        password = passwordField.getText().toString();

        //Attempts to retrieve token with username + password entered by user to confirm login
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient defaultClient = Configuration.getDefaultApiClient();
                defaultClient.setBasePath(getString(R.string.baseurl));

                AccessTokenApi apiInstance = new AccessTokenApi();
                try {
                    final OAuth2Resource result = apiInstance.getOAuthToken(getString(R.string.grant_type), getString(R.string.client_id),
                            null, username, password);
                    userToken = result.getAccessToken();
                    System.out.println("User token: " + userToken);

                    // Configure OAuth2 access token for authorization: OAuth2
                    OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                    OAuth2.setAccessToken(userToken);

                    // Attempt to retrieve userID using the userToken
                    UtilSecurityApi apiInstance2 = new UtilSecurityApi();
                    try {
                        TokenDetailsResource result2 = apiInstance2.getUserTokenDetails();
                        userId = result2.getUserId();
                        System.out.println("UserId: " + userId);
                    }
                    catch (Exception e) {
                        System.err.println("Exception when calling UtilSecurityApi#getUserTokenDetails");
                        e.printStackTrace();
                    }
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loginSuccess();
                        }
                    });
                }
                catch (Exception e) {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            loginError();
                        }
                    });
                    System.err.println("Exception when calling AccessTokenApi#getOAuthToken");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void loginSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void loginError() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "login");
        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    //Called when "Register" button is clicked
    public void openUserRegistration(View view) {
        Intent intent = new Intent(this, UserRegistration.class);
        intent.putExtra("adminToken", adminToken);
        startActivity(intent);
    }
}