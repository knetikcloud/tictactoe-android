package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.TextProperty;
import com.knetikcloud.model.UserResource;

import retrofit2.Call;
import retrofit2.Response;

public class UserRegistration extends AppCompatActivity {
    String username;
    String password;
    String email;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
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

                ApiClient client = ApiClients.getAdminClientInstance(getApplicationContext());
                // Registering the user
                UsersApi apiInstance = client.createService(UsersApi.class);
                try {
                    Call<UserResource> call = apiInstance.registerUser(userResource);
                    Response<UserResource> result = call.execute();
                    System.out.println(result.body());

                    userId = result.body().getId();
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
