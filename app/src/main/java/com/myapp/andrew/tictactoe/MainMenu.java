package com.myapp.andrew.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.knetikcloud.model.ImageProperty;
import com.knetikcloud.model.UserResource;

public class MainMenu extends AbstractActivity {

    // Making the back button inoperable from the main menu to prevent the user from
    // returning to the sign in screen without logging out
    @Override
    public void onBackPressed()
    {

    }

    @Override
    protected void _onCreate(Bundle savedInstanceState) {

        user = ((TicTacToe)getApplicationContext()).getUser();

        setContentView(R.layout.activity_main_menu);

        TextView welcomeLabel = (TextView) findViewById(R.id.welcomeLabel);
        welcomeLabel.setText("Hi, " + user.getUsername());
    }

    private static void onUserLoadError(Object o) {
    }

    public void onUserLoadSuccess(UserResource user) {

        ImageProperty avatar = (ImageProperty)(user.getAdditionalProperties()).get("avatar");
        String imageUrl = avatar.getUrl();

        new DownloadImageTask((ImageView) findViewById(R.id.mainMenuAvatar))
                .execute(imageUrl);
    }

    public void newGame(View view) {

        Intent intent = new Intent(this, GameBoard.class);
        startActivity(intent);
    }

    public void openProfile(View view) {

        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void openStore(View view) {

        Intent intent = new Intent(this, Store.class);
        startActivity(intent);
    }

    public void logOut(View view) {

        ApiClients.resetUserClientInstance();
        ((TicTacToe)getApplicationContext()).setUser(null);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
