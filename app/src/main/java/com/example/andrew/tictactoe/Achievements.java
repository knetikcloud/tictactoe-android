package com.example.andrew.tictactoe;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.knetikcloud.api.GamificationAchievementsApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.ApiException;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.PageResourceUserAchievementGroupResource;
import com.knetikcloud.model.UserAchievementGroupResource;
import com.knetikcloud.model.UserAchievementResource;

import java.util.List;

public class Achievements extends AppCompatActivity {
    String username;
    int userId;
    String adminToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
        adminToken = bundle.getString("adminToken");

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient defaultClient = Configuration.getDefaultApiClient();
                defaultClient.setBasePath(getString(R.string.baseurl));

                // Configure OAuth2 access token for authorization: OAuth2
                OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                OAuth2.setAccessToken(adminToken);

                GamificationAchievementsApi apiInstance = new GamificationAchievementsApi();
                try {
                    final PageResourceUserAchievementGroupResource result = apiInstance.getUserAchievementsProgress(userId, null, null, null, null, null);
                    System.out.println(result);

                    Achievements.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            printAchievements(result);
                        }
                    });

                } catch (ApiException e) {
                    System.err.println("Exception when calling GamificationAchievementsApi#getUserAchievementsProgress");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void printAchievements(PageResourceUserAchievementGroupResource result) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.achievementLinearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;

        List<UserAchievementGroupResource> achievementGroupResources = result.getContent();

        for (UserAchievementGroupResource groupRsc : achievementGroupResources) {
            List<UserAchievementResource> achievementResources = groupRsc.getAchievements();

            for (UserAchievementResource rsc : achievementResources) {
                if (rsc.getAchieved()) {
                    TextView textView = new TextView(getApplicationContext());
                    textView.setText(rsc.getAchievementName());
                    textView.setTextSize(18);
                    textView.setPadding(0, 0, 0, 10);
                    textView.setLayoutParams(layoutParams);
                    linearLayout.addView(textView);
                }
            }
        }
    }
}