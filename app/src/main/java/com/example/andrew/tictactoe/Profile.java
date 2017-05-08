package com.example.andrew.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    String username;
    int userId;
    String adminToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("username");
        userId = bundle.getInt("userId");
        adminToken = bundle.getString("adminToken");

        TextView profileHeader = (TextView) findViewById(R.id.profileHeader);
        profileHeader.setText(username + "'s Profile");

        //TODO: add logic to retrieve avatar from UserResource
        //Placeholder for grabbing avatar from UserResource
        ImageView imageView = (ImageView) findViewById(R.id.profileAvatar);
        imageView.setImageResource(R.drawable.ucf);
    }

    public void changeAvatar(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putInt("userId", userId);
        bundle.putString("adminToken", adminToken);

        Intent intent = new Intent(this, Avatars.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
