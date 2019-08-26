package com.sana;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import org.w3c.dom.Text;

import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by Aws on 11/03/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    /*private Context mContext ;*/
    private List<Model_Challenge> mData ;
    private RequestOptions option;


    public RecyclerViewAdapter(ChallengeActivity challengeActivity, List<Model_Challenge> mData) {
        /*this.mContext = mContext;*/
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round_challenge).error(R.drawable.bg_round_challenge);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.model_challenge,parent,false) ;
        /*final MyViewHolder viewHolder = new MyViewHolder(view) ;*/
        /*viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });*/




        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder (final RecyclerViewAdapter.MyViewHolder holder, int position){

        final Model_Challenge model_challenge = mData.get(position);

        Glide.with(holder.itemView.getContext()).load(mData.get(position).getImg()).apply(option).into(holder.img_thumbnail);
        holder.tv_judul.setText(mData.get(position).getJudul());
        holder.tv_deskripsi.setText(mData.get(position).getDeskripsi());
        holder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, DetailChallenge.class);
                i.putExtra("judul",model_challenge.getJudul());
                i.putExtra("deskripsi",model_challenge.getDeskripsi());
                i.putExtra("img",model_challenge.getImg());
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
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView tv_judul ;
        TextView tv_deskripsi ;
        TextView tv_gabung;
        ImageView img_suka;
        ImageView img_bagi;
        ImageView img_thumbnail;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.bg_challenge);
            tv_judul = itemView.findViewById(R.id.tv_challenge_judul);
            tv_deskripsi = itemView.findViewById(R.id.tv_challenge_desc);
            tv_gabung = itemView.findViewById(R.id.tv_gabung);
            img_suka = itemView.findViewById(R.id.img_like);
            img_bagi = itemView.findViewById(R.id.img_bagi);
            img_thumbnail = itemView.findViewById(R.id.img_challenge);
            recyclerView = itemView.findViewById(R.id.recyclerTemp);

        }
    }

}
