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
import com.sana.feature.event.DetailEvent;
import com.sana.feature.event.EventActivity;
import com.sana.models.Event;


import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    /*private Context mContext ;*/
    private List<Event> mEvent ;
    private RequestOptions option;


    public EventAdapter(EventActivity eventActivity, List<Event> mEvent) {
        /*this.mContext = mContext;*/
        this.mEvent = mEvent;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round_challenge).error(R.drawable.bg_round_challenge);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.model_event,parent,false) ;
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

        final Event model_event = mEvent.get(position);

        Glide.with(holder.itemView.getContext())
                .load(mEvent.get(position).getImg()).apply(option)
                .into(holder.img_event);

        holder.tv_judul.setText(mEvent.get(position).getJudul());
        holder.tv_waktu.setText(mEvent.get(position).getWaktu());
        holder.tv_hari.setText(mEvent.get(position).getHari());
        holder.tv_tempat.setText(mEvent.get(position).getTempat());
        holder.tv_tanggal.setText(mEvent.get(position).getTanggal());
        holder.tv_bulan.setText(mEvent.get(position).getBulan());
        holder.tv_tahun.setText(mEvent.get(position).getTahun());
        holder.tv_waktu.setText(mEvent.get(position).getWaktu());
        holder.tv_group.setText(mEvent.get(position).getGroup());
        /*holder.tv_desk.setText(mEvent.get(position).getDeskripsi());*/
        /*holder.tv_suka.setText(mData.get(position).getSuka());
        holder.tv_bagi.setText(mData.get(position).getBagi());
        holder.tv_gabung.setText(mData.get(position).getGabung());*/

        holder.btn_ikuti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, DetailEvent.class);
                i.putExtra("judul",model_event.getJudul());
                i.putExtra("waktu",model_event.getWaktu());
                i.putExtra("tempat",model_event.getTempat());
                i.putExtra("hari",model_event.getHari());
                i.putExtra("tanggal",model_event.getTanggal());
                i.putExtra("bulan",model_event.getBulan());
                i.putExtra("tahun", model_event.getTahun());
                i.putExtra("img_event",model_event.getImg());
                i.putExtra("group",model_event.getGroup());
                i.putExtra("deskripsi",model_event.getDeskripsi());
                /*i.putExtra("deskripsi",model_event.getDeskripsi());*/
               /* i.putExtra("anime_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());*/

                mContext.startActivity(i);
            }
        });


        // Load Image from the internet and set it into Imageview using Glide






    }

    @Override
    public int getItemCount() {
        return mEvent.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView tv_judul ;
        TextView tv_waktu ;
        TextView tv_hari;
        TextView tv_tempat;
        TextView tv_tanggal;
        TextView tv_bulan;
        TextView tv_tahun;
        TextView tv_group;
        TextView tv_desk;
        Button btn_ikuti;
        ImageView img_event;
        LinearLayout view_container;


        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.bg_challenge);
            tv_judul = itemView.findViewById(R.id.tv_challenge_judul);
            tv_waktu = itemView.findViewById(R.id.tv_waktu);
            tv_hari = itemView.findViewById(R.id.tv_hari);
            tv_tempat = itemView.findViewById(R.id.tv_tempat);
            tv_tanggal = itemView.findViewById(R.id.tv_tanggal);
            tv_tahun = itemView.findViewById(R.id.tv_tahun);
            tv_bulan = itemView.findViewById(R.id.tv_bulan);
            tv_group = itemView.findViewById(R.id.tv_group);
            tv_desk = itemView.findViewById(R.id.detail_deskripsi);
            btn_ikuti = itemView.findViewById(R.id.btn_ikuti);


   /*       tv_gabung = itemView.findViewById(R.id.tv_gabung);
            tv_suka = itemView.findViewById(R.id.tv_suka);
            tv_bagi = itemView.findViewById(R.id.tv_bagi);*/
            img_event = itemView.findViewById(R.id.img_event);
            recyclerView = itemView.findViewById(R.id.recyclerTemp);

        }


    }

}
