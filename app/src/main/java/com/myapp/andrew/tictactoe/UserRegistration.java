package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.TextProperty;
import com.knetikcloud.model.UserResource;
import com.myapp.andrew.tictactoe.util.JsapiCall;

import retrofit2.Call;

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

        final EditText usernameField = (EditText) findViewById(R.id.username);
        EditText passwordField = (EditText) findViewById(R.id.password);
        EditText emailField = (EditText) findViewById(R.id.email);

        username = usernameField.getText().toString();
        password = passwordField.getText().toString();
        email = emailField.getText().toString();


        /******************************************
         * REGISTRATION
         */
        UserResource userResource = new UserResource();
        userResource.setUsername(username);
        userResource.setPassword(password);
        userResource.setEmail(email);

        // Setting the default avatar
        ImageProperty imageProperty = new ImageProperty();
        imageProperty.setType("image");
        imageProperty.setUrl(getString(R.string.default_image));
        userResource.putAdditionalPropertiesItem("avatar", imageProperty);

        //Setting the default gamePieceColor
        TextProperty textProperty = new TextProperty();
        textProperty.setType("text");
        textProperty.setValue(getString(R.string.black));
        userResource.putAdditionalPropertiesItem("gamePieceColor", textProperty);

        ApiClient client = new ApiClient();
        client.getAdapterBuilder().baseUrl(getString(R.string.baseurl));

        // Register user
        UsersApi users = client.createService(UsersApi.class);

        Call<UserResource> createUserCall = users.registerUser(userResource);

        JsapiCall<UserResource> createUserTask = new JsapiCall<UserResource>(this, this::registrationSuccess, null);

        createUserTask.setTitle("Registration");
        createUserTask.setMessage("Creating account...");
        createUserTask.execute(createUserCall);
    }

    public void registrationSuccess(UserResource user) {

        // Authenticate
        ApiClient client = ApiClients.getUserClientInstance(getApplicationContext(), username, password);

        // Attempt to retrieve userID using the userToken
        UsersApi apiInstance = client.createService(UsersApi.class);

        JsapiCall<UserResource> task = new JsapiCall<UserResource>(this, this::loginSuccess, t -> ApiClients.resetUserClientInstance());

        task.setTitle("Authenticating");
        task.setMessage("Verifying credentials...");

        task.execute(apiInstance.getUser("me"));
    }

    private void loginSuccess(UserResource user) {

        ((TicTacToe)getApplicationContext()).setUser(user);

        Intent intent = new Intent(this, MainMenu.class);
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
