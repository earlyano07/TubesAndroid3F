package com.example.windows10.kecelakaan.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.windows10.kecelakaan.DetailKecelakaan;
import com.example.windows10.kecelakaan.History;
import com.example.windows10.kecelakaan.KelolaKecelakaan;
import com.example.windows10.kecelakaan.Model.Kecelakaan;
import com.example.windows10.kecelakaan.R;

import java.util.List;

/**
 * Created by WINDOWS 10 on 11/01/2018.
 */

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.MyViewHolder> {

    String user;
    public Context context;
    List<Kecelakaan> mKecelakaanList;
    public AdapterHistory(Context context){
        this.context = context;
    }

    public AdapterHistory(List <Kecelakaan> KecelakaanList){
        mKecelakaanList = KecelakaanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kecelakaan_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTVdeskripsi.setText(" "+mKecelakaanList.get(position).getDeskripsi());
        holder.mTVwaktu.setText(" "+mKecelakaanList.get(position).getWaktu());
        holder.mTVlokasi.setText(" "+mKecelakaanList.get(position).getLokasi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), KelolaKecelakaan.class);
                mIntent.putExtra("username", mKecelakaanList.get(position).getUsername());
                mIntent.putExtra("id_kecelakaan", mKecelakaanList.get(position).getIdKecelakaan());
                mIntent.putExtra("deskripsi", mKecelakaanList.get(position).getDeskripsi());
                mIntent.putExtra("waktu", mKecelakaanList.get(position).getWaktu());
                mIntent.putExtra("lokasi", mKecelakaanList.get(position).getLokasi());
                mIntent.putExtra("gambar", mKecelakaanList.get(position).getGambar());
                mIntent.putExtra("keterangan", mKecelakaanList.get(position).getKeterangan());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mKecelakaanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTVdeskripsi, mTVwaktu, mTVlokasi, mTVket;
        public ImageView mIVgambar;

        public MyViewHolder(View mView) {
            super(mView);
            mTVdeskripsi = (TextView) mView.findViewById(R.id.tvdeskripsi);
            mTVwaktu = (TextView) mView.findViewById(R.id.tvwaktu);
            mTVlokasi = (TextView) mView.findViewById(R.id.tvtempat);
            mIVgambar = (ImageView) mView.findViewById(R.id.ivgambar);
            mTVket = (TextView) mView.findViewById(R.id.ket);
        }
    }
}
