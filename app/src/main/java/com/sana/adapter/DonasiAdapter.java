package com.sana.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.sana.R;
import com.sana.feature.challenge.ChallengeActivity;
import com.sana.feature.challenge.DetailChallenge;
import com.sana.feature.donasi.DetailDonasiActivity;
import com.sana.feature.donasi.DonasiActivity;
import com.sana.feature.donasi.DonasiProsesActivity;
import com.sana.models.Challenge;
import com.sana.models.Donasi;


import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by Aws on 11/03/2018.
 */

public class DonasiAdapter extends RecyclerView.Adapter<DonasiAdapter.MyViewHolder> {

    private List<Donasi> mData ;
    private RequestOptions option;


    public DonasiAdapter(List<Donasi> mData) {
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round_challenge).error(R.drawable.bg_round_challenge);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.model_donasi,parent,false) ;
        /*final MyViewHolder viewHolder = new MyViewHolder(view) ;*/
        /*viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });*/




        return new MyViewHolder(view);


    }


    @Override
    public void onBindViewHolder (final DonasiAdapter.MyViewHolder holder, int position){

        final Donasi donasi = mData.get(position);
         Glide.with(holder.itemView.getContext())
                 .load(mData.get(position).getGambar())
                 .apply(option)
                 .into(holder.iv_list);

//        Glide.with(holder.itemView.getContext())
//                .load(mData.get(position).getGambar())
//                .apply(option)
//                .into(holder.iv_don);

        holder.tv_judul_list.setText(mData.get(position).getJudul());
//        holder.tv_judul_don.setText(mData.get(position).getJudul());
//        holder.tv_judul_vol.setText(mData.get(position).getJudul());
//        holder.tv_deskripsi_don.setText(mData.get(position).getDeskripsi());
//        holder.tv_deskripsi_vol.setText(mData.get(position).getDeskripsi());
//        holder.tv_user_don.setText(mData.get(position).getUser());
//        holder.tv_user_vol.setText(mData.get(position).getUser());
        holder.tv_hari_list.setText(mData.get(position).getHari());
//        holder.tv_hari_don.setText(mData.get(position).getHari());
//        holder.tv_hari_vol.setText(mData.get(position).getHari());
        holder.tv_join_list.setText(mData.get(position).getJoin());
//        holder.tv_join_don.setText(mData.get(position).getJoin());
//        holder.tv_join_vol.setText(mData.get(position).getJoin());
//        holder.tv_jumlah_don.setText(mData.get(position).getJumlah());
//        holder.tv_tanggal_vol.setText(mData.get(position).getTanggal());
//        holder.tv_lokasi_don.setText(mData.get(position).getLokasi());
//        holder.tv_lokasi_don.setText(mData.get(position).getLokasi());
        holder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, DetailDonasiActivity.class);
                i.putExtra("gambar",donasi.getGambar());
                i.putExtra("judul",donasi.getJudul());
                i.putExtra("deskripsi",donasi.getDeskripsi());
                i.putExtra("user",donasi.getUser());
                i.putExtra("hari",donasi.getHari());
                i.putExtra("tanggal",donasi.getTanggal());
                i.putExtra("joinvol",donasi.getJoin());
                i.putExtra("jumlah",donasi.getJumlah());
                i.putExtra("lokasi",donasi.getLokasi());

                mContext.startActivity(i);
            }
        });

//        holder.btn_donasi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Context mContext = v.getContext();
//                Intent i = new Intent(mContext, DonasiProsesActivity.class);
//                i.putExtra("gambar",donasi.getGambar());
//                i.putExtra("judul",donasi.getJudul());
//
//                mContext.startActivity(i);
//            }
//        });


    }
    @Override
    public int getItemCount() {
        return mData.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView tv_judul_don , tv_judul_vol , tv_deskripsi_don , tv_deskripsi_vol , tv_user_don ,
                tv_user_vol,tv_hari_don ,tv_hari_vol , tv_tanggal_vol ,tv_join_don, tv_join_vol ,
                tv_jumlah_don ,  tv_lokasi_don , tv_lokasi_vol, tv_judul_list ,tv_hari_list,
                tv_tanggal_list,tv_join_list , tv_proses;
        ImageView iv_don , iv_vol ,iv_list , iv_proses;
        CardView view_container;
        Button btn_donasi;

        MyViewHolder(View itemView) {
            super(itemView);

            tv_judul_don = itemView.findViewById(R.id.tv_donasi_judul);
            tv_deskripsi_don = itemView.findViewById(R.id.tv_donasi_deskripsi);
            tv_user_don = itemView.findViewById(R.id.tv_donasi_user);
            tv_hari_don = itemView.findViewById(R.id.tv_donasi_hari);
            tv_join_don = itemView.findViewById(R.id.tv_donasi_join);
            tv_jumlah_don = itemView.findViewById(R.id.tv_donasi_jumlah);
            tv_lokasi_don = itemView.findViewById(R.id.tv_donasi_lokasi);

            tv_judul_vol = itemView.findViewById(R.id.tv_volunteer_judul);
            tv_deskripsi_vol = itemView.findViewById(R.id.tv_volunteer_deskripsi);
            tv_user_vol = itemView.findViewById(R.id.tv_volunteer_user);
            tv_hari_vol = itemView.findViewById(R.id.tv_volunteer_hari);
            tv_join_vol = itemView.findViewById(R.id.tv_volunteer_join);
            tv_tanggal_vol = itemView.findViewById(R.id.tv_volunteer_tanggal);
            tv_lokasi_vol = itemView.findViewById(R.id.tv_volunteer_lokasi);

            tv_judul_list = itemView.findViewById(R.id.tv_judul_list);
            tv_hari_list = itemView.findViewById(R.id.tv_detail_hari_donasi);
            tv_join_list = itemView.findViewById(R.id.tv_orang_baik);


            iv_list = itemView.findViewById(R.id.iv_foto);
            iv_don = itemView.findViewById(R.id.image_view_detail_donasi);
            iv_proses = itemView.findViewById(R.id.iv_donasi_proses);

            view_container = itemView.findViewById(R.id.card_donasi);
            recyclerView = itemView.findViewById(R.id.recyclerdonasi);

            btn_donasi = itemView.findViewById(R.id.button_donasi);
            iv_proses = itemView.findViewById(R.id.iv_donasi_proses);
            tv_proses = itemView.findViewById(R.id.tv_donasi_proses_judul);

        }
    }

}
