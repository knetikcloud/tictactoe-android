package com.myapp.andrew.tictactoe;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.facebook.AccessToken;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Profile extends AppCompatActivity {
    String colorLiteral;
    String errorMessage = "";
    String gamePieceColor;
    int userId;
    String username;

    private CallbackManager callbackManager;
    String facebookAccessToken = null;

    // Setting the back button to always open the main menu
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    //Facebook login button
    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            if(facebookAccessToken != null) {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");

        TextView profileHeader = (TextView) findViewById(R.id.profileHeader);
        profileHeader.setText(username + "'s Profile");

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

                    new DownloadImageTask((ImageView) findViewById(R.id.profileAvatar))
                            .execute(imageUrl);
                } catch (IOException e) {
                    System.err.println("Exception when calling UsersApi#getUser");
                    e.printStackTrace();
                }
            }
        }).start();

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton)findViewById(R.id.login_button);
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

        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                // Retrieves user's level progress
                GamificationLevelingApi apiInstance = client.createService(GamificationLevelingApi.class);
                try {
                    Call<UserLevelingResource> call = apiInstance.getUserLevel(Integer.toString(userId), "TicTacToe");
                    final Response<UserLevelingResource> result = call.execute();

                    if(result.body() != null) {
                        Profile.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setLevelProgress(result.body());
                            }
                        });
                    }
                } catch (IOException e) {
                    System.err.println("Exception when calling GamificationLevelingApi#getUserLevel");
                    e.printStackTrace();
                }

                // Retrieves items from inventory to populate dropdown menu
                UsersInventoryApi apiInstance2 = client.createService(UsersInventoryApi.class);
                Boolean inactive = false; // If true, accepts inactive user inventories
                try {
                    Call<PageResourceUserInventoryResource> call = apiInstance2.getUserInventories(userId, inactive, null, null, null, null, null, null, null);
                    final Response<PageResourceUserInventoryResource> result = call.execute();

                    Profile.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            initializeSpinner(result.body());
                        }
                    });
                } catch (IOException e) {
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
                colorLiteral = parent.getItemAtPosition(position).toString();
                if(position == 0)
                    return;
                else if(colorLiteral.equals("Red"))
                    gamePieceColor = getString(R.string.red);
                else if(colorLiteral.equals("Blue"))
                    gamePieceColor = getString(R.string.blue);
                else if(colorLiteral.equals("Yellow"))
                    gamePieceColor = getString(R.string.yellow);
                else if(colorLiteral.equals("Green"))
                    gamePieceColor = getString(R.string.green);
                else
                    gamePieceColor = getString(R.string.black);
                changeGamePieceColor();
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
    }

    // Changes the additional property "gamePieceColor" in the userResource
    public void changeGamePieceColor() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                UsersApi apiInstance = client.createService(UsersApi.class);
                try {
                    Call<UserResource> call = apiInstance.getUser(Integer.toString(userId));
                    Response<UserResource> result = call.execute();

                    Map<String, Property> additionalProperties = result.body().getAdditionalProperties();
                    TextProperty gamePiece = (TextProperty) additionalProperties.get("gamePieceColor");
                    gamePiece.setValue(gamePieceColor);
                    try {
                        Call call2 = apiInstance.updateUser(Integer.toString(userId), result.body());
                        call2.execute();

                        Profile.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                gamePieceColorSuccess();
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

    public void linkFacebook(final String facebookAccessToken) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext(), username, null);

                SocialFacebookApi apiInstance = client.createService(SocialFacebookApi.class);
                FacebookToken facebookToken = new FacebookToken();
                //facebookToken.accessToken(facebookAccessToken);
                facebookToken.setAccessToken(facebookAccessToken);
                try {
                    Call call = apiInstance.linkAccounts(facebookToken);
                    Response result = call.execute();

                    if(result.isSuccessful()) {
                        Profile.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                linkFacebookSuccess();
                            }
                        });
                    }
                    else {
                        try {
                            JSONObject jObjError = new JSONObject(result.errorBody().string());
                            JSONArray jsonArray = new JSONArray(jObjError.getString("result"));
                            JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
                            errorMessage = jsonObject.getString("message");

                            Profile.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    linkFacebookError(errorMessage);
                                }
                            });
                        } catch(JSONException e) {
                            System.err.println(e.getMessage());
                            e.printStackTrace();

                            Profile.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    linkFacebookError(errorMessage);
                                }
                            });
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Exception when calling SocialFacebookApi#linkAccounts");
                    e.printStackTrace();

                    Profile.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            linkFacebookError(errorMessage);
                        }
                    });
                }
            }
        }).start();
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

    public void linkFacebookSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "facebookSuccess");
        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void linkFacebookError(String errorMessage) {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "facebookError");
        bundle.putString("message", errorMessage);
        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void gamePieceColorSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("argument", "gamePieceColor");
        bundle.putString("color", colorLiteral);
        ResponseDialogs dialog = new ResponseDialogs();
        dialog.setArguments(bundle);
        dialog.show(this.getFragmentManager(), "dialog");
    }

    public void changeAvatar(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, Avatars.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void openAchievements(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);

        Intent intent = new Intent(this, Achievements.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
