package com.myapp.andrew.tictactoe;

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
        else if(argument.equals("gamePieceColor")) {
            String color = getArguments().getString("color");
            builder.setTitle("Success")
                    .setMessage("Your game piece is now " + color +".")
                    .setPositiveButton("OK", null);
        }
        else if(argument.equals("facebookSuccess")) {
            builder.setTitle("Success")
                    .setMessage("Your Facebook and TicTacToe accounts are now connected.")
                    .setPositiveButton("OK", null);
        }
        else if(argument.equals("facebookError")) {
            String message = getArguments().getString("message");
            builder.setTitle("Error")
                    .setMessage("TicTacToe was unable to connect to your Facebook account.\n\n" + message)
                    .setPositiveButton("OK", null);
        }
        else if(argument.equals("stripeCardError")) {
            builder.setTitle("Error")
                    .setMessage("Invalid card. Please check your data and try again.")
                    .setPositiveButton("OK", null);
        }
        else if(argument.equals("subscriptionPurchaseSuccess")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Success")
                    .setMessage("You have successfully purchased this subscription.  It may take some time for the subscription to process.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("subscriptionPurchaseError")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Error")
                    .setMessage("An error occurred while processing your purchase. Please try again later.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("subscriptionCancelSuccess")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Success")
                    .setMessage("Your subscription has been cancelled.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("subscriptionCancelError")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Error")
                    .setMessage("An error occurred while canceling your subscription. Please try again later.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("subscriptionRenewSuccess")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Success")
                    .setMessage("Your subscription has been renewed.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("subscriptionRenewError")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Error")
                    .setMessage("An error occurred while renewing your subscription. Please try again later.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("currencyPurchaseError")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Error")
                    .setMessage("An error occurred while processing your currency purchase. Please try again later.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("currencyPurchaseSuccess")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Success")
                    .setMessage("You have successfully purchased more currency!  It may take some time for the purchase to process.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("currencySubscriptionMissingError")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Error")
                    .setMessage("You must purchase a subscription first.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("currencySubscriptionCancelledError")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Error")
                    .setMessage("You cancelled your subscription.  You must renew it.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(argument.equals("currencyPaymentStripeError")) {
            final int userId = getArguments().getInt("userId");
            final String username = getArguments().getString("username");
            builder.setTitle("Error")
                    .setMessage("Problem with finding a payment method.  Please purchase a subscription.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), Store.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        return builder.create();
    }
}
