package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.Property;
import com.knetikcloud.model.UserResource;
import com.myapp.andrew.tictactoe.util.JsapiCall;

import java.util.Map;

import retrofit2.Call;

public class Avatars extends AbstractActivity {

    private ApiClient client;

    @Override
    protected void _onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_avatars);

        client = ApiClients.getUserClientInstance(getApplicationContext());
    }

    // Changes the additional property "avatar" in the userResource
    public void avatarSelected(final View view) {

        // we reload the user before making a change
        UsersApi users = client.createService(UsersApi.class);
        Call<UserResource> loadUserCall = users.getUser("me");

        JsapiCall<UserResource> loadUserTask = new JsapiCall<UserResource>(this, user -> {

            app.setUser(user);

            // then we make the change
            Map<String, Property> additionalProperties = user.getAdditionalProperties();

            ImageProperty avatar = (ImageProperty) additionalProperties.get("avatar");

            if (avatar == null) {
                avatar = new ImageProperty();
                additionalProperties.put("avatar", avatar);
            }

            avatar.setUrl(view.getTag().toString());

            Call<Void> updateUserCall = users.updateUser("me", user);
            JsapiCall<Void> updateUserTask = new JsapiCall<Void>(this, u -> {
                loadProfile();
            }, s -> {
                Log.wtf("profile", "unable to update user's avatar");
            });

            updateUserTask.setTitle("User Details");
            updateUserTask.setMessage("Saving preferences...");
            updateUserTask.execute(updateUserCall);

        }, t -> {
            Log.wtf("profile", "unable to load user");
        });

        loadUserTask.setTitle("User Details");
        loadUserTask.setMessage("Synchronizing...");
        loadUserTask.execute(loadUserCall);
    }

    public void loadProfile() {

        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}
