package com.myapp.andrew.tictactoe;

import java.util.ArrayList;
import java.util.List;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.knetikcloud.api.ActivitiesApi;
import com.knetikcloud.api.RuleEngineEventsApi;
import com.knetikcloud.api.GamificationLevelingApi;
import com.knetikcloud.api.UsersApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.ActivityOccurrenceResource;
import com.knetikcloud.model.CreateActivityOccurrenceRequest;
import com.knetikcloud.model.ActivityOccurrenceResults;
import com.knetikcloud.model.ActivityOccurrenceResultsResource;
import com.knetikcloud.model.BreEvent;
import com.knetikcloud.model.IntWrapper;
import com.knetikcloud.model.Property;
import com.knetikcloud.model.TextProperty;
import com.knetikcloud.model.UserActivityResultsResource;
import com.knetikcloud.model.UserResource;
import com.knetikcloud.model.ActivityOccurrenceStatusWrapper;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Response;

import static java.lang.Integer.parseInt;

public class GameBoard extends AppCompatActivity {

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

        // Attempts to retrieve the "gamePieceColor" additional property from the userResource
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                UsersApi apiInstance = client.createService(UsersApi.class);
                try {
                    Call<UserResource> call = apiInstance.getUser(Integer.toString(userId));
                    Response<UserResource> result = call.execute();
                    System.out.println(result.body());

                    Map<String, Property> map = result.body().getAdditionalProperties();
                    System.out.println("MAP: " + map);
                    TextProperty gamePieceProperty = (TextProperty)map.get("gamePieceColor");
                    gamePieceColor = gamePieceProperty.getValue();
                    System.out.println("gamePieceColor: " + gamePieceColor);
                } catch (IOException e) {
                    System.err.println("Exception when calling UsersApi#getUser");
                    e.printStackTrace();
                }

                // Creating a new activity occurrence
                ActivitiesApi apiInstance2 = client.createService(ActivitiesApi.class);
                Boolean test = false; // Boolean | if true, indicates that the occurrence should NOT be created. This can be used to test for eligibility and valid settings
                CreateActivityOccurrenceRequest createActivityOccurrenceRequest = new CreateActivityOccurrenceRequest(); // ActivityOccurrenceResource | The activity occurrence object
                createActivityOccurrenceRequest.setActivityId(Long.valueOf(R.string.activity_id)); //Long.valueOf("3L")
                createActivityOccurrenceRequest.setChallengeActivityId(Long.valueOf(R.string.challenge_activity_id));
                createActivityOccurrenceRequest.setEventId(Long.valueOf(R.string.event_id));
                try {
                    Call<ActivityOccurrenceResource> call = apiInstance2.createActivityOccurrence(test, createActivityOccurrenceRequest);
                    Response<ActivityOccurrenceResource> result = call.execute();
                    System.out.println(result.body());
                    activityOccurrenceId = result.body().getId();

                } catch (IOException e) {
                    System.err.println("Exception when calling ActivitiesApi#createActivityOccurrence");
                    e.printStackTrace();
                }
            }
        }).start();

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

                if(value.equals("X")) {
                    bundle.putString("outcome", "win");
                }
                else {
                    bundle.putString("outcome", "loss");
                }
                GameOutcomeDialog dialog = new GameOutcomeDialog();
                dialog.setArguments(bundle);
                dialog.show(this.getSupportFragmentManager(), "dialog");


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                        // Report game results
                        ActivitiesApi apiInstance = client.createService(ActivitiesApi.class);
                        ActivityOccurrenceResultsResource activityOccurrenceResults = new ActivityOccurrenceResultsResource(); // ActivityOccurrenceResultsResource | The activity occurrence object

                        UserActivityResultsResource userActivityResultsResource = new UserActivityResultsResource();
                        userActivityResultsResource.setScore(1L);
                        userActivityResultsResource.setUserId(userId);

                        List<UserActivityResultsResource> userActivityResultsResources = new ArrayList<UserActivityResultsResource>();
                        userActivityResultsResources.add(userActivityResultsResource);
                        activityOccurrenceResults.setUsers(userActivityResultsResources);

                        try {
                            Call<ActivityOccurrenceResults> call = apiInstance.setActivityOccurrenceResults(activityOccurrenceId, activityOccurrenceResults);
                            Response<ActivityOccurrenceResults> result = call.execute();
                            System.out.println(result.body());
                        } catch (IOException e) {
                            System.err.println("Exception when calling ActivitiesApi#setActivityOccurrenceResults");
                            e.printStackTrace();
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

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            ApiClient client = ApiClients.getUserClientInstance(getApplicationContext());

                            // Report game results
                            ActivitiesApi apiInstance = client.createService(ActivitiesApi.class);
                            ActivityOccurrenceResultsResource activityOccurrenceResults = new ActivityOccurrenceResultsResource(); // ActivityOccurrenceResultsResource | The activity occurrence object

                            UserActivityResultsResource userActivityResultsResource = new UserActivityResultsResource();
                            userActivityResultsResource.setScore(0L);
                            userActivityResultsResource.setUserId(userId);

                            List<UserActivityResultsResource> userActivityResultsResources = new ArrayList<UserActivityResultsResource>();
                            userActivityResultsResources.add(userActivityResultsResource);
                            activityOccurrenceResults.setUsers(userActivityResultsResources);

                            try {
                                Call<ActivityOccurrenceResults> call = apiInstance.setActivityOccurrenceResults(activityOccurrenceId, activityOccurrenceResults);
                                Response<ActivityOccurrenceResults> result = call.execute();
                                System.out.println(result.body());
                            } catch (IOException e) {
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
