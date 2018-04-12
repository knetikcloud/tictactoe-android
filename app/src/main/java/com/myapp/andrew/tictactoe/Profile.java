package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.knetikcloud.api.GamificationLevelingApi;
import com.knetikcloud.api.SocialFacebookApi;
import com.knetikcloud.api.UsersApi;
import com.knetikcloud.api.UsersInventoryApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.FacebookToken;
import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.PageResourceUserInventoryResource;
import com.knetikcloud.model.Property;
import com.knetikcloud.model.TextProperty;
import com.knetikcloud.model.UserInventoryResource;
import com.knetikcloud.model.UserLevelingResource;
import com.knetikcloud.model.UserResource;
import com.myapp.andrew.tictactoe.util.JsapiCall;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class Profile extends AbstractActivity {

    String colorLiteral;
    String errorMessage = "";
    String gamePieceColor;

    private CallbackManager callbackManager;
    String facebookAccessToken = null;

    private ApiClient client;

    // Setting the back button to always open the main menu
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    //Facebook login button
    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            if (facebookAccessToken != null) {
                linkFacebook(facebookAccessToken);
            }
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };

    @Override
    protected void _onCreate(Bundle savedInstanceState) {

        client = ApiClients.getUserClientInstance(getApplicationContext());

        setContentView(R.layout.activity_profile);

        TextView profileHeader = (TextView) findViewById(R.id.profileHeader);
        profileHeader.setText(user.getUsername() + "'s Profile");

        Map<String, Property> map = user.getAdditionalProperties();
        ImageProperty avatar = (ImageProperty) map.get("avatar");
        String imageUrl = avatar.getUrl();

        new DownloadImageTask((ImageView) findViewById(R.id.profileAvatar))
                .execute(imageUrl);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);

        callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                facebookAccessToken = loginResult.getAccessToken().getToken();
                linkFacebook(facebookAccessToken);
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
            }
        };

        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, callback);

        // Retrieves user's level progress

        GamificationLevelingApi levels = client.createService(GamificationLevelingApi.class);
        Call<UserLevelingResource> levelsCall = levels.getUserLevel("me", "TicTacToe");

        JsapiCall<UserLevelingResource> levelsTask = new JsapiCall<UserLevelingResource>(this, this::onLevelLoaded, e -> {
            onLevelLoaded(null);
        });
        levelsTask.setTitle("User Details");
        levelsTask.setMessage("Loading level...");
        levelsTask.execute(levelsCall);
    }

    public void onLevelLoaded(UserLevelingResource level) {

        setLevelProgress(level);

        // Retrieves items from inventory to populate dropdown menu
        UsersInventoryApi inventory = client.createService(UsersInventoryApi.class);
        Boolean inactive = false; // If true, accepts inactive user inventories

        Call<PageResourceUserInventoryResource> inventoryCall = inventory.getUserInventories(user.getId(), inactive, null, null, null, null, null, null, null);

        JsapiCall<PageResourceUserInventoryResource> inventoryTask = new JsapiCall<PageResourceUserInventoryResource>(this, this::onInventoryLoaded, t -> {
            Log.wtf("profile", "unable to load user inventory");
        });
        inventoryTask.setTitle("User Details");
        inventoryTask.setMessage("Loading inventory...");
        inventoryTask.execute(inventoryCall);
    }

    // Sets the leveling progressbar, and labels displaying current level and total wins
    public void setLevelProgress(UserLevelingResource result) {

        if (result == null)
            return;

        TextView currentLevel = (TextView) findViewById(R.id.profileCurrentLevelLabel);
        TextView totalWins = (TextView) findViewById(R.id.profileTotalWinsLabel);
        TextView progressBarWinCount = (TextView) findViewById(R.id.progressBarWinCountLabel);
        ProgressBar levelProgressBar = (ProgressBar) findViewById(R.id.levelProgressBar);

        if (result.getLastTierName() == null) {
            totalWins.setText("Total Wins: " + result.getProgress().toString());
            progressBarWinCount.setText(result.getProgress() + "/" + result.getNextTierProgress() + " wins");
            levelProgressBar.setMax(result.getNextTierProgress());
            levelProgressBar.setProgress(result.getProgress());
        } else {
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
    public void onInventoryLoaded(PageResourceUserInventoryResource result) {

        Spinner spinner = (Spinner) findViewById(R.id.gamePieceSpinner);

        List<UserInventoryResource> userInventoryResources = result.getContent();
        List<String> spinnerItems = new ArrayList<String>();

        spinnerItems.add("Select Color");
        spinnerItems.add("Black");

        for (UserInventoryResource rsc : userInventoryResources) {
            String itemName = rsc.getItemName();
            if (itemName.substring(0, 9).equals("gamePiece")) {
                spinnerItems.add(itemName.substring(9));
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                colorLiteral = parent.getItemAtPosition(position).toString();
                if (position == 0)
                    return;
                else if (colorLiteral.equals("Red"))
                    gamePieceColor = getString(R.string.red);
                else if (colorLiteral.equals("Blue"))
                    gamePieceColor = getString(R.string.blue);
                else if (colorLiteral.equals("Yellow"))
                    gamePieceColor = getString(R.string.yellow);
                else if (colorLiteral.equals("Green"))
                    gamePieceColor = getString(R.string.green);
                else
                    gamePieceColor = getString(R.string.black);
                changeGamePieceColor();
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    // Changes the additional property "gamePieceColor" in the userResource
    public void changeGamePieceColor() {

        // we reload the user before making a change
        UsersApi users = client.createService(UsersApi.class);
        Call<UserResource> loadUserCall = users.getUser("me");

        JsapiCall<UserResource> loadUserTask = new JsapiCall<UserResource>(this, user -> {

            app.setUser(user);

            // then we make the change
            Map<String, Property> additionalProperties = user.getAdditionalProperties();
            TextProperty gamePiece = (TextProperty) additionalProperties.get("gamePieceColor");

            if (gamePiece == null) {
                gamePiece = new TextProperty();
                additionalProperties.put("gamePieceColor", gamePiece);
            }

            gamePiece.setValue(gamePieceColor);

            Call<Void> updateUserCall = users.updateUser("me", user);
            JsapiCall<Void> updateUserTask = new JsapiCall<Void>(this, null, s -> {
                Log.wtf("profile", "unable to update user's game piece");
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

    public void linkFacebook(final String facebookAccessToken) {

        SocialFacebookApi facebook = client.createService(SocialFacebookApi.class);

        FacebookToken facebookToken = new FacebookToken();
        facebookToken.setAccessToken(facebookAccessToken);

        Call linkCall = facebook.linkAccounts(facebookToken);

        JsapiCall<Void> linkTask = new JsapiCall<Void>(this, t -> {}, t -> {
            Log.wtf("profile", "unable to link facebook account");
        });
        linkTask.setTitle("User Details");
        linkTask.setMessage("Linking with Facebook...");
        linkTask.execute(linkCall);
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*if(facebookAccessToken != null)
            linkFacebook(facebookAccessToken);*/
    }

    @Override
    protected void onPause() {

        super.onPause();
    }

    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
        super.onActivityResult(requestCode, responseCode, intent);
        //Facebook login
        callbackManager.onActivityResult(requestCode, responseCode, intent);

    }

    public void changeAvatar(View view) {
        Intent intent = new Intent(this, Avatars.class);
        startActivity(intent);
    }

    public void openAchievements(View view) {
        Intent intent = new Intent(this, Achievements.class);
        startActivity(intent);
    }

}
