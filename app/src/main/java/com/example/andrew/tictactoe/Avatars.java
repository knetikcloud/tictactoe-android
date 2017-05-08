package com.example.andrew.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Avatars extends AppCompatActivity {
    String username;
    int userId;
    String adminToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatars);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
        adminToken = bundle.getString("adminToken");
    }

    public void avatarSelected(View view) {
        //TODO: add logic to change avatar in UserResource
        System.out.println(view.getTag());
    }
}
