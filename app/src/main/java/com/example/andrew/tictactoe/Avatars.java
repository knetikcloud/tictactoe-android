package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.ApiException;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.UserResource;

public class Avatars extends AppCompatActivity {
    String username;
    int userId;
    String adminToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatars);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
        adminToken = bundle.getString("adminToken");
    }

    public void avatarSelected(final View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient defaultClient = Configuration.getDefaultApiClient();
                defaultClient.setBasePath(getString(R.string.baseurl));

                // Configure OAuth2 access token for authorization: OAuth2
                OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                OAuth2.setAccessToken(adminToken);

                UsersApi apiInstance = new UsersApi();
                try {
                    UserResource userResource = apiInstance.getUser(Integer.toString(userId));
                    System.out.println(userResource);

                    ImageProperty imageProperty = new ImageProperty();
                    imageProperty.setType("image");
                    imageProperty.setUrl(view.getTag().toString());
                    userResource.putAdditionalPropertiesItem("avatar", imageProperty);

                    try {
                        apiInstance.updateUser(Integer.toString(userId), userResource);
                    } catch (ApiException e) {
                        System.err.println("Exception when calling UsersApi#updateUser");
                        e.printStackTrace();
                    }
                } catch (ApiException e) {
                    System.err.println("Exception when calling UsersApi#getUser");
                    e.printStackTrace();
                }
            }
        }).start();
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, Profile.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
