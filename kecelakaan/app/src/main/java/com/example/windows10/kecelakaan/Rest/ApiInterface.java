package com.example.windows10.kecelakaan.Rest;

import com.example.windows10.kecelakaan.Model.GetKecelakaan;
import com.example.windows10.kecelakaan.Model.GetUser;
import com.example.windows10.kecelakaan.Model.PostPutDelKecelakaan;
import com.example.windows10.kecelakaan.Model.PostPutDelUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by WINDOWS 10 on 24/12/2017.
 */

public interface ApiInterface {

    @GET("kecelakaan")
    Call<GetKecelakaan> getKecelakaan(@Query("username") String username);
    @FormUrlEncoded
    @POST("kecelakaan")
    Call<PostPutDelKecelakaan> postKecelakaan(@Field("deskripsi") String deskripsi,
                                              @Field("lokasi") String lokasi,
                                              @Field("keterangan") String keterangan,
                                              @Field("username") String username);
    @FormUrlEncoded
    @PUT("kecelakaan")
    Call<PostPutDelKecelakaan> putKecelakaan(@Field("id_kecelakaan") String idKecelakaan,
                                            @Field("deskripsi") String deskripsi,
                                              @Field("lokasi") String lokasi,
                                              @Field("keterangan") String keterangan);
                                                //@Field("username") String username);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kecelakaan", hasBody = true)
    Call<PostPutDelKecelakaan> deleteKecelakaan(@Field("id_kecelakaan") String idKecelakaan);

    @GET("user")
    Call<GetUser> getUser(@Query("username") String username,
                          @Query("password") String password);

    @FormUrlEncoded
    @POST("user")
    Call<PostPutDelUser> postUser(@Field("username") String username,
                                        @Field("password") String password,
                                        @Field("alamat") String alamat,
                                        @Field("telp") String telp,
                                        @Field("email") String email);
    @FormUrlEncoded
    @PUT("user")
    Call<PostPutDelUser> putUser(@Field("id_user") String id_user,
                                        @Field("username") String deskripsi,
                                       @Field("password") String password,
                                       @Field("alamat") String alamat,
                                       @Field("telp") String telp,
                                       @Field("email") String email);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "user", hasBody = true)
    Call<PostPutDelUser> deleteUser(@Field("id_user") String id_user);
}
