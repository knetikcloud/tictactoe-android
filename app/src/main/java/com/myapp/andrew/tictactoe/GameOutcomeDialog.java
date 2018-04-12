package com.myapp.andrew.tictactoe;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class GameOutcomeDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String outcome = getArguments().getString("outcome");

        String title = outcome.equals("WIN") ? "Congratulations" : "Game Over";
        String message = outcome.equals("WIN") ? "You Won!" : (outcome.equals("LOSS") ? "You've lost :-(" : "It's a draw");
        message += " Start new game?";

        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("YEAH", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getActivity(), GameBoard.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Nope", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getActivity(), MainMenu.class);
                        startActivity(intent);
                    }
                });

        return builder.create();
    }
}
