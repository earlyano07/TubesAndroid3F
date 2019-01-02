package com.example.windows10.kecelakaan.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windows10.kecelakaan.DetailKecelakaan;
import com.example.windows10.kecelakaan.Model.Kecelakaan;
import com.example.windows10.kecelakaan.R;

import java.util.List;

/**
 * Created by WINDOWS 10 on 24/12/2017.
 */

public class AdapterKecelakaan extends RecyclerView.Adapter<AdapterKecelakaan.MyViewHolder>{

    String user;
    List<Kecelakaan> mKecelakaanList;

    public AdapterKecelakaan(List <Kecelakaan> KecelakaanList){
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
                Intent mIntent = new Intent(view.getContext(), DetailKecelakaan.class);
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

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView mTVdeskripsi, mTVwaktu, mTVlokasi;
        public ImageView mIVgambar;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTVdeskripsi = (TextView) itemView.findViewById(R.id.tvdeskripsi);
            mTVwaktu = (TextView) itemView.findViewById(R.id.tvwaktu);
            mTVlokasi = (TextView) itemView.findViewById(R.id.tvtempat);
            mIVgambar = (ImageView) itemView.findViewById(R.id.ivgambar);
        }
    }
}
