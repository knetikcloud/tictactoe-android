package com.myapp.andrew.tictactoe;

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
import com.myapp.andrew.tictactoe.util.JsapiCall;

import java.util.List;

import retrofit2.Call;

public class Achievements extends AbstractActivity {

    ApiClient client;

    @Override
    protected void _onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_achievements);

        client = ApiClients.getUserClientInstance(getApplicationContext());

        GamificationAchievementsApi achievements = client.createService(GamificationAchievementsApi.class);

        Call<PageResourceUserAchievementGroupResource> loadAchievementsCall = achievements.getUserAchievementsProgress(user.getId(), null, null, null, null, null);

        JsapiCall<PageResourceUserAchievementGroupResource> loadAchievementsTask = new JsapiCall<PageResourceUserAchievementGroupResource>(this, this::printAchievements, null);

        loadAchievementsTask.setTitle("Achievements");
        loadAchievementsTask.setMessage("Loading achievements");
        loadAchievementsTask.execute(loadAchievementsCall);
    }

    public void printAchievements(PageResourceUserAchievementGroupResource result) {

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.achievementLinearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;

        List<UserAchievementGroupResource> achievementGroupResources = result.getContent();

        boolean achievementsUnlocked = false;

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
                    achievementsUnlocked = true;
                }
            }
        }

        if (!achievementsUnlocked) {
            TextView textView = new TextView(getApplicationContext());
            textView.setText("No achievements unlocked.");
            textView.setTextSize(18);
            textView.setPadding(0, 0, 0, 10);
            textView.setLayoutParams(layoutParams);
            linearLayout.addView(textView);
        }
    }
}