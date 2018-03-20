package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.Property;
import com.knetikcloud.model.UserResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

public class MainMenu extends AppCompatActivity {
    String username;
    int userId;

    // Making the back button inoperable from the main menu to prevent the user from
    // returning to the sign in screen without logging out
    @Override
    public void onBackPressed()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
        TextView welcomeLabel = (TextView) findViewById(R.id.welcomeLabel);
        welcomeLabel.setText("Hi, "+username);

        // Attempts to retrieve the "avatar" additional property from the userResource
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                UsersApi apiInstance = client.createService(UsersApi.class);
                try {
                    Call<UserResource> call = apiInstance.getUser(Integer.toString(userId));
                    Response<UserResource> result = call.execute();

                    Map<String, Property> map = result.body().getAdditionalProperties();

                    ImageProperty avatar = (ImageProperty)map.get("avatar");
                    String imageUrl = avatar.getUrl();

                    new DownloadImageTask((ImageView) findViewById(R.id.mainMenuAvatar))
                            .execute(imageUrl);
                } catch (IOException e) {
                    System.err.println("Exception when calling UsersApi#getUser");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void newGame(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, GameBoard.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openProfile(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, Profile.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openStore(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, Store.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void logOut(View view) {
        ApiClients.resetUserClientInstance();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
