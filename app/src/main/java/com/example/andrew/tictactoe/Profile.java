package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.knetikcloud.api.GamificationLevelingApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.ApiException;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.UserLevelingResource;

public class Profile extends AppCompatActivity {
    String username;
    int userId;
    String adminToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
        adminToken = bundle.getString("adminToken");

        TextView profileHeader = (TextView) findViewById(R.id.profileHeader);
        profileHeader.setText(username + "'s Profile");

        //TODO: add logic to retrieve avatar from UserResource
        //Placeholder for grabbing avatar from UserResource
        ImageView imageView = (ImageView) findViewById(R.id.profileAvatar);
        imageView.setImageResource(R.drawable.ucf);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient defaultClient = Configuration.getDefaultApiClient();
                defaultClient.setBasePath(getString(R.string.baseurl));

                // Configure OAuth2 access token for authorization: OAuth2
                OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                OAuth2.setAccessToken(adminToken);

                GamificationLevelingApi apiInstance = new GamificationLevelingApi();
                try {
                    final UserLevelingResource result = apiInstance.getUserLevel(userId, "TicTacToe");
                    System.out.println(result);

                    Profile.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setLevelProgress(result);
                        }
                    });
                } catch (ApiException e) {
                    System.err.println("Exception when calling GamificationLevelingApi#getUserLevel");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void setLevelProgress(UserLevelingResource result) {
        TextView currentLevel = (TextView) findViewById(R.id.profileCurrentLevelLabel);
        TextView totalWins = (TextView) findViewById(R.id.profileTotalWinsLabel);
        TextView progressBarWinCount = (TextView) findViewById(R.id.progressBarWinCountLabel);
        ProgressBar levelProgressBar = (ProgressBar) findViewById(R.id.levelProgressBar);

        if(result.getLastTierName() == null) {
            totalWins.setText("Total Wins: " + result.getProgress().toString());
            progressBarWinCount.setText(result.getProgress() + "/" + result.getNextTierProgress() + " wins");
            levelProgressBar.setMax(result.getNextTierProgress());
            levelProgressBar.setProgress(result.getProgress());
        }
        else {
            currentLevel.setText("Current Level: " + result.getLastTierName());
            totalWins.setText("Total Wins: " + result.getProgress().toString());
            int winCount1 = result.getProgress() - result.getLastTierProgress();
            int winCount2 = result.getNextTierProgress() - result.getLastTierProgress();
            progressBarWinCount.setText(winCount1 + "/" + winCount2 + " wins");
            levelProgressBar.setMax(winCount2);
            levelProgressBar.setProgress(winCount1);
        }
    }

    public void changeAvatar(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, Avatars.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openAchievements(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, Achievements.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
