package com.example.andrew.tictactoe;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by Andrew on 5/2/2017.
 */

public class ResponseDialogs extends DialogFragment {

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String argument = getArguments().getString("argument");

        if(argument.equals("login")) {
            builder.setTitle("Error")
                    .setMessage("Unable to login. Please check your username and password and try again.")
                    .setPositiveButton("OK", null);
        }
        else if(argument.equals("register")) {
            builder.setTitle("Error")
                    .setMessage("Unable to register. Please make sure that all fields are filled out correctly.")
                    .setPositiveButton("OK", null);
        }
        else if(argument.equals("insufficientFunds")) {
            builder.setTitle("Insufficent Funds")
                    .setMessage("You do not have enough TTD to purchase this item.")
                    .setPositiveButton("OK", null);
        }
        else if(argument.equals("facebookSuccess")) {
            builder.setTitle("Success")
                    .setMessage("Your Facebook and TicTacToe accounts are now connected.")
                    .setPositiveButton("OK", null);
        }
        else if(argument.equals("facebookError")) {
            builder.setTitle("Error")
                    .setMessage("TicTacToe was unable to connect to your Facebook account.")
                    .setPositiveButton("OK", null);
        }
        return builder.create();
    }
}
