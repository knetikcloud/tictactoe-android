package com.myapp.andrew.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.knetikcloud.api.ActivitiesApi;
import com.knetikcloud.api.BRERuleEngineEventsApi;
import com.knetikcloud.api.GamificationAchievementsApi;
import com.knetikcloud.api.GamificationLevelingApi;
import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.client.ApiException;
import com.knetikcloud.client.Configuration;
import com.knetikcloud.client.auth.OAuth;
import com.knetikcloud.model.AOccurrenceOfAnActivityTheActualGameForExampleUsedToTrackScoresParticipantsAndProvideSettings;
import com.knetikcloud.model.ActivityOccurrenceResults;
import com.knetikcloud.model.BreEvent;
import com.knetikcloud.model.UserAchievementGroupResource;
import com.knetikcloud.model.UserResource;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class GameBoard extends AppCompatActivity {

    String adminToken;
    Long activityOccurrenceId;
    String currPlayer = "X";
    Boolean gameOver = false;
    String gamePieceColor;
    String[] squares = new String[9];
    int userId;
    String username;
    int[][] winningCombos = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
        adminToken = bundle.getString("adminToken");

        // Attempts to retrieve the "gamePieceColor" additional property from the userResource
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

                    //FIXME: Retrieve gamePieceColor from UserResource
        /*          Map<String, Property> map = result.getAdditionalProperties();
                    System.out.println("MAP: " + map);
                    String gamePieceColor = map.get("gamePieceColor").toString();
                    System.out.println("gamePieceColor: " + gamePieceColor);*/
                } catch (ApiException e) {
                    System.err.println("Exception when calling UsersApi#getUser");
                    e.printStackTrace();
                }

                // Creating a new activity occurrence
                ActivitiesApi apiInstance2 = new ActivitiesApi();
                Boolean test = false; // Boolean | if true, indicates that the occurrence should NOT be created. This can be used to test for eligibility and valid settings
                AOccurrenceOfAnActivityTheActualGameForExampleUsedToTrackScoresParticipantsAndProvideSettings activityOccurrenceResource = new AOccurrenceOfAnActivityTheActualGameForExampleUsedToTrackScoresParticipantsAndProvideSettings(); // AOccurrenceOfAnActivityTheActualGameForExampleUsedToTrackScoresParticipantsAndProvideSettings | The activity occurrence object
                activityOccurrenceResource.setActivityId(3L);
                activityOccurrenceResource.setChallengeActivityId(8L);
                activityOccurrenceResource.setEventId(1L);
                try {
                    AOccurrenceOfAnActivityTheActualGameForExampleUsedToTrackScoresParticipantsAndProvideSettings result = apiInstance2.createActivityOccurrence(test, activityOccurrenceResource);
                    System.out.println(result);
                    activityOccurrenceId = result.getId();

                    // Changing status of activity occurrence to "PLAYING"
                    try {
                        apiInstance2.updateActivityOccurrence(activityOccurrenceId, "PLAYING");
                    } catch (ApiException e) {
                        System.err.println("Exception when calling ActivitiesApi#updateActivityOccurrence");
                        e.printStackTrace();
                    }
                } catch (ApiException e) {
                    System.err.println("Exception when calling ActivitiesApi#createActivityOccurrence");
                    e.printStackTrace();
                }
            }
        }).start();

        //FIXME: Remove after fixing gamePieceColor retrieval
        gamePieceColor = "#000000";
    }

    // Called whenever one of the 9 squares is clicked
    public void squareClick(View view) {
        Button button = (Button)view;
        String value = button.getText().toString();
        String id = button.getTag().toString();
        int index = parseInt(id.substring(3,4)) - 1;

        // The square has not yet been played
        if(value.equals("")) {
            button.setText(currPlayer);
            button.setTextColor(Color.parseColor(gamePieceColor));
            squares[index] = currPlayer;
        }
        // The square is already taken
        else
            return;

        checkForWinner("X");
        if(!gameOver) {
            // Start the AI's turn
            currPlayer = "O";
            aiStartMove();
        }
        else
            gameOver = false;
    }

    public void aiStartMove() {
        Boolean aiMove = false;
        Random rand = new Random();
        while(!aiMove) {
            int moveToAttempt = rand.nextInt(9) + 1;
            if(squares[moveToAttempt - 1] == null) {
                squares[moveToAttempt - 1] = currPlayer;
                String temp = "sqr" + moveToAttempt;
                int id = getResources().getIdentifier(temp, "id", getPackageName());
                Button button = (Button) findViewById(id);
                button.setText(currPlayer);
                aiMove = true;
            }
        }
        checkForWinner("O");
        currPlayer = "X";
    }

    // Evaluates whether or not the game is over (win, loss, or draw)
    public void checkForWinner(final String value) {
        // Checks for a win or loss
        for (int i = 0; i < winningCombos.length; i++) {
            if (squares[winningCombos[i][0]] == value && squares[winningCombos[i][1]] == value && squares[winningCombos[i][2]] == value) {
                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                bundle.putInt("userId", userId);
                bundle.putString("adminToken", adminToken);

                final GamePlayedEvent gamePlayedEvent = new GamePlayedEvent();
                gamePlayedEvent.setUserId(userId);

                if(value.equals("X")) {
                    bundle.putString("outcome", "win");
                    gamePlayedEvent.setVictory(true);
                }
                else {
                    bundle.putString("outcome", "loss");
                    gamePlayedEvent.setVictory(false);
                }
                GameOutcomeDialog dialog = new GameOutcomeDialog();
                dialog.setArguments(bundle);
                dialog.show(this.getSupportFragmentManager(), "dialog");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ApiClient defaultClient = Configuration.getDefaultApiClient();
                        defaultClient.setBasePath(getString(R.string.baseurl));

                        // Configure OAuth2 access token for authorization: OAuth2
                        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                        OAuth2.setAccessToken(adminToken);

                        BreEvent breEvent = new BreEvent();
                        breEvent.setEventName("Game Played");
                        breEvent.setParams(gamePlayedEvent);

                        BRERuleEngineEventsApi apiInstance = new BRERuleEngineEventsApi();
                        try {
                            apiInstance.sendBREEvent(breEvent);
                            System.out.println("Game Played event fired for userId " + userId);
                        }
                        catch (ApiException e) {
                            System.err.println("Exception when calling BRERuleEngineEventsApi#sendBREEvent");
                            e.printStackTrace();
                        }

                        // Change status of activity occurrence to "FINISHED"
                        ActivitiesApi apiInstance2 = new ActivitiesApi();
                        ActivityOccurrenceResults activityOccurrenceResults = new ActivityOccurrenceResults(); // ActivityOccurrenceResults | The activity occurrence object
                        try {
                            ActivityOccurrenceResults result = apiInstance2.setActivityOccurrenceResults(activityOccurrenceId, activityOccurrenceResults);
                            System.out.println(result);
                        } catch (ApiException e) {
                            System.err.println("Exception when calling ActivitiesApi#setActivityOccurrenceResults");
                            e.printStackTrace();
                        }

                        // Increment user's leveling progress by 1
                        if(value.equals("X")) {
                            GamificationLevelingApi apiInstance3 = new GamificationLevelingApi();
                            try {
                                apiInstance3.incrementProgress(userId, "TicTacToe", 1);
                            } catch (ApiException e) {
                                System.err.println("Exception when calling GamificationLevelingApi#incrementProgress");
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
                reset();
                return;
            }
        }
        // Checks for a draw
        for(int i = 0; i < squares.length; i++) {
            if(squares[i] != null) {
                if(i == squares.length - 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("outcome", "draw");
                    bundle.putString("username", username);
                    bundle.putInt("userId", userId);
                    bundle.putString("adminToken", adminToken);

                    final GamePlayedEvent gamePlayedEvent = new GamePlayedEvent();
                    gamePlayedEvent.setUserId(userId);
                    gamePlayedEvent.setVictory(false);

                    GameOutcomeDialog dialog = new GameOutcomeDialog();
                    dialog.setArguments(bundle);
                    dialog.show(this.getSupportFragmentManager(), "dialog");

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ApiClient defaultClient = Configuration.getDefaultApiClient();
                            defaultClient.setBasePath(getString(R.string.baseurl));

                            // Configure OAuth2 access token for authorization: OAuth2
                            OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
                            OAuth2.setAccessToken(adminToken);

                            BreEvent breEvent = new BreEvent();
                            breEvent.setEventName("Game Played");
                            breEvent.setParams(gamePlayedEvent);

                            BRERuleEngineEventsApi apiInstance = new BRERuleEngineEventsApi();
                            try {
                                apiInstance.sendBREEvent(breEvent);
                            }
                            catch (Exception e) {
                                System.err.println("Exception when calling BRERuleEngineEventsApi#sendBREEvent");
                                e.printStackTrace();
                            }

                            // Change status of activity occurrence to "FINISHED"
                            ActivitiesApi apiInstance2 = new ActivitiesApi();
                            ActivityOccurrenceResults activityOccurrenceResults = new ActivityOccurrenceResults(); // ActivityOccurrenceResults | The activity occurrence object
                            try {
                                ActivityOccurrenceResults result = apiInstance2.setActivityOccurrenceResults(activityOccurrenceId, activityOccurrenceResults);
                                System.out.println(result);
                            } catch (ApiException e) {
                                System.err.println("Exception when calling ActivitiesApi#setActivityOccurrenceResults");
                                e.printStackTrace();
                            }
                        }
                    }).start();
                    reset();
                    return;
                }
            }
            else
                break;
        }
    }

    public void reset() {
        for(int i = 1; i <= 9; i++){
            String temp = "sqr" + i;
            int id = getResources().getIdentifier(temp, "id", getPackageName());
            Button button = (Button) findViewById(id);
            button.setText("");
        }
        squares = new String[9];
        currPlayer = "X";
        gameOver = true;
    }
}
