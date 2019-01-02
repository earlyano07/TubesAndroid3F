package com.example.windows10.kecelakaan;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.windows10.kecelakaan.Model.PostPutDelKecelakaan;
import com.example.windows10.kecelakaan.Rest.ApiClient;
import com.example.windows10.kecelakaan.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertKecelakaan extends AppCompatActivity {

    EditText eDesk, eKet, eLok;
    Button btSv;
    ImageButton btImg;
    ImageView img;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_kecelakaan);

        final String username = getIntent().getStringExtra("username");

        eDesk = (EditText) findViewById(R.id.etdesk);
        eKet = (EditText) findViewById(R.id.etket);
        eLok = (EditText) findViewById(R.id.etlokasi);
        img = (ImageView) findViewById(R.id.ivhasil);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btSv = (Button) findViewById(R.id.btnSave);
        btImg = (ImageButton) findViewById(R.id.ibgmbr);

        btSv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<PostPutDelKecelakaan> postKecelakaanCall = mApiInterface.postKecelakaan(eDesk.getText().toString(), eLok.getText().toString(), eKet.getText().toString(), username);
                postKecelakaanCall.enqueue(new Callback<PostPutDelKecelakaan>() {
                    @Override
                    public void onResponse(Call<PostPutDelKecelakaan> call, Response<PostPutDelKecelakaan> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelKecelakaan> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureImage();
            }
        });

        if(!isDeviceSupportCamera()){
            Toast.makeText(getApplicationContext(), "Camera Tidak Tersedia", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void captureImage(){
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePicture.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePicture, 100);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 100 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setVisibility(View.VISIBLE);
            img.setImageBitmap(imageBitmap);
        }
    }

    private boolean isDeviceSupportCamera(){
        if(getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)){
            return true;
        } else{
            return false;
        }
    }
}
