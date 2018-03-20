package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.Property;
import com.knetikcloud.model.UserResource;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

public class Avatars extends AppCompatActivity {
    int userId;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatars);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
    }

    // Changes the additional property "avatar" in the userResource
    public void avatarSelected(final View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                UsersApi apiInstance = client.createService(UsersApi.class);
                try {
                    Call<UserResource> call = apiInstance.getUser(Integer.toString(userId));
                    Response<UserResource> result = call.execute();

                    Map<String, Property> additionalProperties = result.body().getAdditionalProperties();
                    ImageProperty avatar = (ImageProperty) additionalProperties.get("avatar");
                    avatar.setUrl(view.getTag().toString());
                    try {
                        Call call2 = apiInstance.updateUser(Integer.toString(userId), result.body());
                        call2.execute();

                        Avatars.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loadProfile();
                            }
                        });
                    } catch (IOException e) {
                        System.err.println("Exception when calling UsersApi#updateUser");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.err.println("Exception when calling UsersApi#getUser");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void loadProfile() {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, Profile.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
