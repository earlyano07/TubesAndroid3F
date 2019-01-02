package com.example.windows10.kecelakaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.windows10.kecelakaan.Adapter.AdapterKecelakaan;
import com.example.windows10.kecelakaan.Model.GetKecelakaan;
import com.example.windows10.kecelakaan.Model.Kecelakaan;
import com.example.windows10.kecelakaan.Rest.ApiClient;
import com.example.windows10.kecelakaan.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageButton insert;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String username = getIntent().getStringExtra("username");
        insert = (ImageButton) findViewById(R.id.btnInsert);
        insert.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), InsertKecelakaan.class);
                in.putExtra("username", username);
                startActivity(in);
            }
        });
        
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
        refresh();
    }

    public void refresh() {
        String user = "";
        Call<GetKecelakaan> kecelakaanCall = mApiInterface.getKecelakaan(user);
        kecelakaanCall.enqueue(new Callback<GetKecelakaan>() {
            @Override
            public void onResponse(Call<GetKecelakaan> call, Response<GetKecelakaan> response) {
                List<Kecelakaan> KecelakaanList = response.body().getListDataKecelakaan();
                Log.d("Retrofit Get", "Jumlah Data Kecelakaan : " + String.valueOf(KecelakaanList.size()));
                mAdapter = new AdapterKecelakaan(KecelakaanList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetKecelakaan> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
