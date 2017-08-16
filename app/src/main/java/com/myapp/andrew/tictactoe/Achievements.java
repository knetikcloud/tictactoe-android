package com.myapp.andrew.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.knetikcloud.api.GamificationAchievementsApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.PageResourceUserAchievementGroupResource;
import com.knetikcloud.model.UserAchievementGroupResource;
import com.knetikcloud.model.UserAchievementResource;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Achievements extends AppCompatActivity {
    String username;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getAdminClientInstance(getApplicationContext());

                GamificationAchievementsApi apiInstance = client.createService(GamificationAchievementsApi.class);
                try {
                    Call<PageResourceUserAchievementGroupResource> call = apiInstance.getUserAchievementsProgress(userId, null, null, null, null, null);
                    final Response<PageResourceUserAchievementGroupResource> result = call.execute();
                    System.out.println(result.body());

                    Achievements.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            printAchievements(result.body());
                        }
                    });

                } catch (IOException e) {
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
                if (rsc.isAchieved()) {
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