package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.knetikcloud.api.UtilSecurityApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.TokenDetailsResource;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    int userId;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext(), username, password);

                // Attempt to retrieve userID using the userToken
                UtilSecurityApi apiInstance = client.createService(UtilSecurityApi.class);
                try {
                    Call<TokenDetailsResource> call = apiInstance.getUserTokenDetails();
                    Response<TokenDetailsResource> result = call.execute();

                    userId = result.body().getUserId();

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
                    ApiClients.resetUserClientInstance();
                    System.err.println("Exception when calling UtilSecurityApi#getUserTokenDetails");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void loginSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

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
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        //dont allow it
    }
}