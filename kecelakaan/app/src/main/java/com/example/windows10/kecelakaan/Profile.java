package com.example.windows10.kecelakaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends AppCompatActivity {

    EditText user, pass, almt, telp, mail;
    Button edtP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        almt = (EditText) findViewById(R.id.alamat);
        telp = (EditText) findViewById(R.id.hp);
        mail = (EditText) findViewById(R.id.email);

        Intent m = getIntent();
        user.setText(m.getStringExtra("username"));
        pass.setText(m.getStringExtra("password"));
        almt.setText(m.getStringExtra("alamat"));
        telp.setText(m.getStringExtra("telp"));
        mail.setText(m.getStringExtra("email"));

    }
}
