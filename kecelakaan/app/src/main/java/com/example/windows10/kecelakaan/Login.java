package com.example.windows10.kecelakaan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.windows10.kecelakaan.Model.GetUser;
import com.example.windows10.kecelakaan.Model.Kecelakaan;
import com.example.windows10.kecelakaan.Model.PostPutDelKecelakaan;
import com.example.windows10.kecelakaan.Model.PostPutDelUser;
import com.example.windows10.kecelakaan.Model.User;
import com.example.windows10.kecelakaan.Rest.ApiClient;
import com.example.windows10.kecelakaan.Rest.ApiInterface;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.password;

public class Login extends AppCompatActivity {

    private EditText username, pass;
    private Button login;
    private TextView regis;
    private ApiInterface mApiInterface;

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //this.checkSavedCredentials();
        this.username = (EditText) findViewById(R.id.etUsername);
        this.pass = (EditText) findViewById(R.id.etPassword);
        this.regis = (TextView) findViewById(R.id.regis);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        this.login = (Button) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                login();
            }
        });

        regis.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private void login(){
        final String username = this.username.getText().toString();
        String password = this.pass.getText().toString();

        Call<GetUser> cekUser = mApiInterface.getUser(this.username.getText().toString(), this.pass.getText().toString());
        cekUser.enqueue(new Callback<GetUser>() {
            @Override
            public void onResponse(Call<GetUser> call, Response<GetUser> response) {
                openHome(username);
            }

            @Override
            public void onFailure(Call<GetUser> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void openHome(String username){
        final int position = 0;

        Intent in = new Intent(this.getApplicationContext(), Menu.class);
        in.putExtra("username", this.username.getText().toString());
        this.startActivity(in);
    }
}
