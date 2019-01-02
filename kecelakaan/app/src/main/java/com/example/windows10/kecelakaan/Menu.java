package com.example.windows10.kecelakaan;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    ImageButton dftr, user, hist, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final String username = getIntent().getStringExtra("username");
        dftr = (ImageButton) findViewById(R.id.daftar);
        user = (ImageButton) findViewById(R.id.profil);
        hist = (ImageButton) findViewById(R.id.hostori);
        logout = (ImageButton) findViewById(R.id.logout);

        dftr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                in.putExtra("username", username);
                startActivity(in);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), Profile.class);
                in.putExtra("username", username);
                startActivity(in);
            }
        });

        hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), History.class);
                in.putExtra("username", username);
                startActivity(in);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), Login.class);
                startActivity(in);
            }
        });
    }
}
