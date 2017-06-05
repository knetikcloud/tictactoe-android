package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.knetikcloud.api.GamificationLevelingApi;
import com.knetikcloud.api.UsersApi;
import com.knetikcloud.api.UsersInventoryApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.ApiException;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.PageResourceUserInventoryResource;
import com.knetikcloud.model.TextProperty;
import com.knetikcloud.model.UserInventoryResource;
import com.knetikcloud.model.UserLevelingResource;
import com.knetikcloud.model.UserResource;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {
    String adminToken;
    int userId;
    String username;

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

                // Retrieves user's level progress
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

                // Retrieves items from inventory to populate dropdown menu
                UsersInventoryApi apiInstance3 = new UsersInventoryApi();
                Boolean inactive = false; // If true, accepts inactive user inventories
                try {
                    final PageResourceUserInventoryResource result = apiInstance3.getUserInventories(userId, inactive, null, null, null, null, null, null, null);
                    System.out.println(result);

                    Profile.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initializeSpinner(result);
                        }
                    });
                } catch (ApiException e) {
                    System.err.println("Exception when calling UsersInventoryApi#getUserInventories");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // Sets the leveling progressbar, and labels displaying current level and total wins
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

    // Populates dropdown menu with available gamePiece colors
    public void initializeSpinner(PageResourceUserInventoryResource result) {
        Spinner spinner = (Spinner) findViewById(R.id.gamePieceSpinner);
        List<UserInventoryResource> userInventoryResources = result.getContent();
        List<String> spinnerItems = new ArrayList<String>();
        spinnerItems.add("Select Color");
        spinnerItems.add("Black");

        for(UserInventoryResource rsc : userInventoryResources) {
            String itemName = rsc.getItemName();
            if(itemName.substring(0, 9).equals("gamePiece")) {
                spinnerItems.add(itemName.substring(9));
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                TextProperty textProperty = new TextProperty();
                textProperty.setType("text");
                if(position == 0)
                    return;
                else if(selectedItem.equals("Red"))
                    textProperty.setValue(getString(R.string.red));
                else if(selectedItem.equals("Blue"))
                    textProperty.setValue(getString(R.string.red));
                else if(selectedItem.equals("Yellow"))
                    textProperty.setValue(getString(R.string.yellow));
                else if(selectedItem.equals("Green"))
                    textProperty.setValue(getString(R.string.green));
                else
                    textProperty.setValue(getString(R.string.black));
                changeGamePieceColor(textProperty);
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }

    // Changes the additional property "gamePieceColor" in the userResource
    public void changeGamePieceColor(final TextProperty textProperty) {
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

                    userResource.putAdditionalPropertiesItem("gamePieceColor", textProperty);
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
