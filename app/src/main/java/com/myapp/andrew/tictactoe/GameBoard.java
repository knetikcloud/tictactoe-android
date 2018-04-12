package com.myapp.andrew.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.knetikcloud.api.ActivitiesApi;
import com.knetikcloud.client.ApiClient;
import com.knetikcloud.model.ActivityOccurrenceResource;
import com.knetikcloud.model.ActivityOccurrenceResults;
import com.knetikcloud.model.ActivityOccurrenceResultsResource;
import com.knetikcloud.model.CreateActivityOccurrenceRequest;
import com.knetikcloud.model.Property;
import com.knetikcloud.model.TextProperty;
import com.knetikcloud.model.UserActivityResultsResource;
import com.myapp.andrew.tictactoe.util.JsapiCall;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;

import static java.lang.Integer.parseInt;

public class GameBoard extends AbstractActivity {

    ActivityOccurrenceResource occurrence;

    ApiClient client;
    ActivitiesApi activities;

    String currPlayer = "X";
    Boolean gameOver = false;
    String gamePieceColor;
    String[] squares = new String[9];
    int[][] winningCombos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    private static enum Outcome {
        WIN, LOSS, DRAW
    }

    @Override
    protected void _onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_game_board);

        Map<String, Property> map = user.getAdditionalProperties();
        TextProperty gamePieceProperty = (TextProperty) map.get("gamePieceColor");

        gamePieceColor = gamePieceProperty != null ? gamePieceProperty.getValue() : "black";

        client = ApiClients.getUserClientInstance(getApplicationContext());

        // Creating a new activity occurrence
        activities = client.createService(ActivitiesApi.class);

        Boolean test = false; // Boolean | if true, indicates that the occurrence should NOT be created. This can be used to test for eligibility and valid settings
        CreateActivityOccurrenceRequest createActivityOccurrenceRequest = new CreateActivityOccurrenceRequest(); // ActivityOccurrenceResource | The activity occurrence object

        createActivityOccurrenceRequest.setActivityId(Long.valueOf(getString(R.string.activity_id)));
        createActivityOccurrenceRequest.setChallengeActivityId(Long.valueOf(getString(R.string.challenge_activity_id)));
        createActivityOccurrenceRequest.setEventId(Long.valueOf(getString(R.string.event_id)));

        Call<ActivityOccurrenceResource> call = activities.createActivityOccurrence(test, createActivityOccurrenceRequest);

        JsapiCall<ActivityOccurrenceResource> task = new JsapiCall<ActivityOccurrenceResource>(this, this::onCreateActivitySuccess
                , null);
        task.setTitle("TicTacToe");
        task.setMessage("Starting game...");

        task.execute(call);
    }

    private void onCreateActivitySuccess(ActivityOccurrenceResource occurrence) {
        this.occurrence = occurrence;
    }

    // Called whenever one of the 9 squares is clicked
    public void squareClick(View view) {
        Button button = (Button) view;
        String value = button.getText().toString();
        String id = button.getTag().toString();
        int index = parseInt(id.substring(3, 4)) - 1;

        // The square has not yet been played
        if (value.equals("")) {
            button.setText(currPlayer);
            button.setTextColor(Color.parseColor(gamePieceColor));
            squares[index] = currPlayer;
        }
        // The square is already taken
        else
            return;

        checkForWinner("X");
        if (!gameOver) {
            // Start the AI's turn
            currPlayer = "O";
            aiStartMove();
        } else
            gameOver = false;
    }

    public void aiStartMove() {
        Boolean aiMove = false;
        Random rand = new Random();
        while (!aiMove) {
            int moveToAttempt = rand.nextInt(9) + 1;
            if (squares[moveToAttempt - 1] == null) {
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
    // This meethods is called after each move
    public void checkForWinner(final String value) {

        Outcome outcome = null;

        // Checks for a win or loss
        for (int i = 0; i < winningCombos.length; i++) {
            if (squares[winningCombos[i][0]] == value && squares[winningCombos[i][1]] == value && squares[winningCombos[i][2]] == value) {

                Bundle bundle = new Bundle();

                if (value.equals("X")) {
                    outcome = Outcome.WIN;
                } else {
                    outcome = Outcome.LOSS;
                }
            }
        }

        // maybe a draw
        if (outcome == null) {

            // Checks for a draw
            for (int i = 0; i < squares.length; i++) {
                if (squares[i] != null) {
                    if (i == squares.length - 1) {
                        outcome = Outcome.DRAW;
                    }
                } else
                    break;
            }
        }

        if (outcome != null) {
            Bundle bundle = new Bundle();

            bundle.putString("outcome", outcome.name());

            GameOutcomeDialog dialog = new GameOutcomeDialog();
            dialog.setArguments(bundle);
            dialog.show(this.getSupportFragmentManager(), "dialog");

            client = ApiClients.getUserClientInstance(getApplicationContext());

            // Report game results
            ActivityOccurrenceResultsResource activityOccurrenceResults = new ActivityOccurrenceResultsResource(); // ActivityOccurrenceResultsResource | The activity occurrence object

            UserActivityResultsResource userActivityResultsResource = new UserActivityResultsResource();
            userActivityResultsResource.setScore(outcome == Outcome.DRAW ? 0L : (outcome == Outcome.WIN ? 1L : -1L));
            userActivityResultsResource.setUserId(user.getId());

            List<UserActivityResultsResource> userActivityResultsResources = Arrays.asList(userActivityResultsResource);
            activityOccurrenceResults.setUsers(userActivityResultsResources);

            // post "scores"
            Call<ActivityOccurrenceResults> resultsCall = activities.setActivityOccurrenceResults(occurrence.getId(), activityOccurrenceResults);

            JsapiCall<ActivityOccurrenceResults> resultsTask = new JsapiCall<>(this, null, null);
            resultsTask.setTitle("TicTacToe");
            resultsTask.setMessage("Processing results...");
            resultsTask.execute(resultsCall);

            // clear grid
            reset();
        }
    }

    public void reset() {

        for (int i = 1; i <= 9; i++) {
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
