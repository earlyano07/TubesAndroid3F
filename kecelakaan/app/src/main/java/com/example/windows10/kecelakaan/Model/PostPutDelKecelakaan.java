package com.example.windows10.kecelakaan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WINDOWS 10 on 24/12/2017.
 */

public class PostPutDelKecelakaan {

    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("result")
    @Expose
    Kecelakaan mKecelakaan;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Kecelakaan getKecelakaan() {
        return mKecelakaan;
    }

    public void setKecelakaan(Kecelakaan Kecelakaan) {
        mKecelakaan = Kecelakaan;
    }
}
