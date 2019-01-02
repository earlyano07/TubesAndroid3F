package com.example.windows10.kecelakaan.Rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WINDOWS 10 on 24/12/2017.
 */

public class ApiClient {

    //public static final String BASE_URL = "http://192.168.43.57:81/pelaporanserver/index.php/";
    public static final String BASE_URL = "http://192.168.43.140:8080/pelaporanserver/index.php/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
