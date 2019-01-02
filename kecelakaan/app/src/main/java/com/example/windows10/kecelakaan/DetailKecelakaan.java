package com.example.windows10.kecelakaan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailKecelakaan extends AppCompatActivity {

    TextView d1, d2, d3, d4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kecelakaan);

        d1 = (TextView) findViewById(R.id.user);
        d2 = (TextView) findViewById(R.id.dtdeskripsi);
        d3 = (TextView) findViewById(R.id.dwaktu);
        d4 = (TextView) findViewById(R.id.dtempat);

        d1.setText(getIntent().getStringExtra("username"));
        d2.setText(getIntent().getStringExtra("deskripsi"));
        d3.setText(getIntent().getStringExtra("waktu"));
        d4.setText(getIntent().getStringExtra("lokasi"));
    }
}
