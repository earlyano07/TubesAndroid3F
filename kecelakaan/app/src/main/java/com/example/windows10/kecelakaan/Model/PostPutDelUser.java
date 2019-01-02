package com.example.windows10.kecelakaan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by WINDOWS 10 on 09/01/2018.
 */

public class PostPutDelUser {

    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("result")
    @Expose
    User mUser;

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
}
