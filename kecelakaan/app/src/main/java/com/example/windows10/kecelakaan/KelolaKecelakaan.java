package com.example.windows10.kecelakaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.windows10.kecelakaan.Model.PostPutDelKecelakaan;
import com.example.windows10.kecelakaan.Rest.ApiClient;
import com.example.windows10.kecelakaan.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KelolaKecelakaan extends AppCompatActivity {

    ImageButton edit, del;
    EditText desk, lokasi, keterangan;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_kecelakaan);

        desk = (EditText) findViewById(R.id.desk);
        keterangan = (EditText) findViewById(R.id.ket);
        lokasi = (EditText) findViewById(R.id.lokasi);

        Intent m = getIntent();
        desk.setText(m.getStringExtra("deskripsi"));
        keterangan.setText(m.getStringExtra("keterangan"));
        lokasi.setText(m.getStringExtra("lokasi"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        edit = (ImageButton) findViewById(R.id.btnEdit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelKecelakaan> updateKecelakaan = mApiInterface.putKecelakaan(
                        getIntent().getStringExtra("id_kecelakaan"),
                        desk.getText().toString(),
                        keterangan.getText().toString(),
                        lokasi.getText().toString());

                updateKecelakaan.enqueue(new Callback<PostPutDelKecelakaan>() {
                    @Override
                    public void onResponse(Call<PostPutDelKecelakaan> call, Response<PostPutDelKecelakaan> response) {
                        History.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelKecelakaan> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Gagal Edit Data", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        del = (ImageButton) findViewById(R.id.btnDelete);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelKecelakaan> deleteKecelakaan = mApiInterface.deleteKecelakaan(getIntent().getStringExtra("id_kecelakaan"));
                deleteKecelakaan.enqueue(new Callback<PostPutDelKecelakaan>() {
                    @Override
                    public void onResponse(Call<PostPutDelKecelakaan> call, Response<PostPutDelKecelakaan> response) {
                        History.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelKecelakaan> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Gagal Hapus Data", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });
    }
}
