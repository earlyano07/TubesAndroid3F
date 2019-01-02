package com.example.windows10.kecelakaan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WINDOWS 10 on 09/01/2018.
 */

public class GetUser {

    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("result")
    @Expose
    User mUser;
    List<User> listDataUser;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User User) {
        mUser = User;
    }

//    @SerializedName("status")
//    @Expose
//    String status;
//    @SerializedName("result")
//    @Expose
//    List<User> listDataUser;
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
    public List<User> getListDataUser() {
        return listDataUser;
    }

    public void setListDataUser(List<User> listDataUser) {
        this.listDataUser = listDataUser;
    }
}
