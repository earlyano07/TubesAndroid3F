package com.example.windows10.kecelakaan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by WINDOWS 10 on 24/12/2017.
 */

public class Kecelakaan {


    @SerializedName("id_kecelakaan")
    @Expose
    private String idKecelakaan;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("waktu")
    @Expose
    private String waktu;
    @SerializedName("lokasi")
    @Expose
    private String lokasi;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("username")
    @Expose
    private String username;

    public Kecelakaan(){}

    public Kecelakaan(String idKecelakaan, String deskripsi, String waktu, String lokasi, String gambar, String keterangan, String username){
        this.idKecelakaan = idKecelakaan;
        this.deskripsi = deskripsi;
        this.waktu = waktu;
        this.lokasi = lokasi;
        this.gambar = gambar;
        this.keterangan = keterangan;
        this.username = username;
    }
    public String getIdKecelakaan() {
        return idKecelakaan;
    }

    public void setIdKecelakaan(String idKecelakaan) {
        this.idKecelakaan = idKecelakaan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.keterangan = username;
    }
}
