package com.example.andrew.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class GameBoard extends AppCompatActivity {

    Boolean gameOver = false;
    String currPlayer = "X";
    int[][] winningCombos = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    String[] squares = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
    }

    public void squareClick(View view) {
        Button button = (Button)view;
        String value = button.getText().toString();
        String id = button.getTag().toString();
        int index = parseInt(id.substring(3,4)) - 1;

        if(value.equals("")) {
            button.setText(currPlayer);
            squares[index] = currPlayer;
        }
        else
            return;

        checkForWinner("X");
        if(!gameOver) {
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

    public void checkForWinner(String value) {
        // Checks for a win or loss
        for (int i = 0; i < winningCombos.length; i++) {
            if (squares[winningCombos[i][0]] == value && squares[winningCombos[i][1]] == value && squares[winningCombos[i][2]] == value) {
                // Win/Loss logic here
                Bundle bundle = new Bundle();
                if(value.equals("X"))
                    bundle.putString("outcome","win");
                else
                    bundle.putString("outcome", "loss");
                GameOutcomeDialog dialog = new GameOutcomeDialog();
                dialog.setArguments(bundle);
                dialog.show(this.getSupportFragmentManager(), "dialog");
                reset();
            }
        }
        // Checks for a draw
        for(int i = 0; i < squares.length; i++) {
            if(squares[i] != null) {
                if(i == squares.length - 1) {
                    Bundle bundle = new Bundle();
                    bundle.putString("outcome", "draw");
                    GameOutcomeDialog dialog = new GameOutcomeDialog();
                    dialog.setArguments(bundle);
                    dialog.show(this.getSupportFragmentManager(), "dialog");
                    reset();
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
