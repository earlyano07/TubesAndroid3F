package com.example.windows10.kecelakaan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by WINDOWS 10 on 09/01/2018.
 */

public class User {

    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("telp")
    @Expose
    private String telp;
    @SerializedName("email")
    @Expose
    private String email;

    public User(){}

    public User(String idUser, String username, String password, String alamat, String telp, String email){
        this.idUser = idUser;
        this.password = password;
        this.alamat = alamat;
        this.telp = telp;
        this.email = email;
        this.username = username;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
