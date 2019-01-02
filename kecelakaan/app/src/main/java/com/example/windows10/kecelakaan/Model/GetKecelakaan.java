package com.example.windows10.kecelakaan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WINDOWS 10 on 24/12/2017.
 */

public class GetKecelakaan {

    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("result")
    @Expose
    List<Kecelakaan> listDataKecelakaan;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Kecelakaan> getListDataKecelakaan() {
        return listDataKecelakaan;
    }

    public void setListDataKecelakaan(List<Kecelakaan> listDataKecelakaan) {
        this.listDataKecelakaan = listDataKecelakaan;
    }
}
