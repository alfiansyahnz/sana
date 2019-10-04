package com.sana.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.sana.R;
import com.sana.feature.challenge.ChallengeActivity;
import com.sana.feature.challenge.DetailChallenge;
import com.sana.models.Challenge;
import com.sana.models.Donasi;


import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by Aws on 11/03/2018.
 */

public class DonasiAdapter extends RecyclerView.Adapter<DonasiAdapter.MyViewHolder> {

    /*private Context mContext ;*/
    private List<Donasi> mData ;
    private RequestOptions option;
   /* private ItemClickCallBack itemClickCallBack;

    public interface ItemClickCallBack{
        void onItemClick(View v, int p);

        void onSecondaryClick(int p)
    }*/


    public DonasiAdapter(ChallengeActivity challengeActivity, List<Donasi> mData) {
        /*this.mContext = mContext;*/
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round_challenge).error(R.drawable.bg_round_challenge);

    }

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
    public void onBindViewHolder (final MyViewHolder holder, int position){

        final Donasi model_donasi = mData.get(position);

        /* holder.view_container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animations));
         */
//        Glide.with(holder.itemView.getContext()).load(mData.get(position).getGambar()).apply(option).into(holder.img_thumbnail);
//        holder.tv_judul.setText(mData.get(position).getJudul());
//        holder.tv_deskripsi.setText(mData.get(position).getDeskripsi());


        holder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, DetailChallenge.class);
                i.putExtra("judul",model_donasi.getJudul());
                i.putExtra("deskripsi",model_donasi.getDeskripsi());
                i.putExtra("img",model_donasi.getGambar());


                mContext.startActivity(i);
            }
        });








    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView tv_judul_don , tv_judul_vol , tv_deskripsi_don , tv_deskripsi_vol , tv_user_don ,
                tv_user_vol,tv_hari_don ,tv_hari_vol , tv_tanggal_don  , tv_tanggal_vol ,tv_join_don,
                tv_join_vol , tv_jumlah_don , tv_jumlah_vol , tv_lokasi_don , tv_lokasi_vol;
        ImageView iv_don , iv_vol;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.bg_challenge);
//            tv_judul = itemView.findViewById(R.id.tv_challenge_judul);
//            tv_deskripsi = itemView.findViewById(R.id.tv_challenge_desc);
//            img_thumbnail = itemView.findViewById(R.id.img_challenge);
            recyclerView = itemView.findViewById(R.id.recyclerTemp);

        }
    }

}
