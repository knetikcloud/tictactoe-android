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

public class ErrorDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String error = getArguments().getString("error");

        if(error.equals("login")) {
            builder.setTitle("Error")
                    .setMessage("Unable to login. Please check your username and password and try again.")
                    .setPositiveButton("OK", null);
        }
        return builder.create();
    }
}
