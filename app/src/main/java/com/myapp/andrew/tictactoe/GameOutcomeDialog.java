package com.myapp.andrew.tictactoe;

        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.app.DialogFragment;
        import android.support.v7.app.AlertDialog;

/**
 * Created by Andrew on 4/26/2017.
 */

public class GameOutcomeDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String outcome = getArguments().getString("outcome");
        final String username = getArguments().getString("username");
        final int userId = getArguments().getInt("userId");

        if(outcome.equals("win")) {
            builder.setTitle("Congratulations!")
                    .setMessage("You won!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), MainMenu.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else if(outcome.equals("loss")) {
            builder.setTitle("Game Over")
                    .setMessage("You've lost")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), MainMenu.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        else {
            builder.setTitle("Game Over")
                    .setMessage("It's a draw!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            bundle.putString("username", username);
                            bundle.putInt("userId", userId);

                            Intent intent = new Intent(getActivity(), MainMenu.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
        }
        return builder.create();
    }
}
