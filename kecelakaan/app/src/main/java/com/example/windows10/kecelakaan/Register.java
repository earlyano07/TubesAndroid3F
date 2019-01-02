package com.example.windows10.kecelakaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.windows10.kecelakaan.Model.PostPutDelKecelakaan;
import com.example.windows10.kecelakaan.Model.PostPutDelUser;
import com.example.windows10.kecelakaan.Rest.ApiClient;
import com.example.windows10.kecelakaan.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText eUser, ePass, eAlamat, eTelp, eEmail;
    Button btRg;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eUser = (EditText) findViewById(R.id.rusername);
        ePass = (EditText) findViewById(R.id.rpassword);
        eAlamat = (EditText) findViewById(R.id.ralamat);
        eTelp = (EditText) findViewById(R.id.rhp);
        eEmail = (EditText) findViewById(R.id.remail);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btRg = (Button) findViewById(R.id.btnregis);
        btRg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelUser> postUserCall = mApiInterface.postUser(eUser.getText().toString(), ePass.getText().toString(), eAlamat.getText().toString(), eTelp.getText().toString(), eEmail.getText().toString());
                postUserCall.enqueue(new Callback<PostPutDelUser>() {
                    @Override
                    public void onResponse(Call<PostPutDelUser> call, Response<PostPutDelUser> response) {
                        Intent intent = new Intent(Register.this, Login.class);
                        finish();
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<PostPutDelUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Silakan Login", Toast.LENGTH_LONG).show();
                    }
                });
        }
        });
    }
}
