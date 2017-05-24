package com.example.andrew.tictactoe;

import android.content.Intent;
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
import com.knetikcloud.client.ApiException;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.OAuth2Resource;
import com.knetikcloud.model.Property;
import com.knetikcloud.model.UserResource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MainMenu extends AppCompatActivity {
    String username;
    int userId;
    String adminToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
        adminToken = bundle.getString("adminToken");
        TextView welcomeLabel = (TextView) findViewById(R.id.welcomeLabel);
        welcomeLabel.setText("Hi, "+username);

        // Attempts to get the userResource
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient defaultClient = Configuration.getDefaultApiClient();
                defaultClient.setBasePath(getString(R.string.baseurl));

                OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                OAuth2.setAccessToken(adminToken);

                UsersApi apiInstance = new UsersApi();
                try {
                    UserResource result = apiInstance.getUser(Integer.toString(userId));
                    System.out.println(result);

                    //FIXME: Retrieve avatar URL from UserResource
/*                    Map<String, Property> map = result.getAdditionalProperties();
                    System.out.println("MAP: " + map);
                    String imageUrl = map.get("avatar").toString();
                    System.out.println("IMAGE URL: " + imageUrl);

                    new DownloadImageTask((ImageView) findViewById(R.id.mainMenuAvatar))
                            .execute(imageUrl);*/
                } catch (ApiException e) {
                    System.err.println("Exception when calling UsersApi#getUser");
                    e.printStackTrace();
                }
            }
        }).start();

        //Placeholder for grabbing avatar from UserResource
        ImageView imageView = (ImageView) findViewById(R.id.mainMenuAvatar);
        imageView.setImageResource(R.drawable.ucf);
    }

    public void newGame(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, GameBoard.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openProfile(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, Profile.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openStore(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, Store.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // Retrieves avatar image from URL
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
