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
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.MainActivity;
import com.sana.R;
import com.sana.models.Model_Berita;


import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.GridViewHolder> {

    /*private Context mContext ;*/
    private List<Model_Berita> mData ;
    private RequestOptions option;

   /* private ItemClickCallBack itemClickCallBack;

    public interface ItemClickCallBack{
        void onItemClick(View v, int p);

        void onSecondaryClick(int p)
    }*/


//    public GridViewAdapter(DetailBerita detailBerita) {
////        /*this.mContext = mContext;*/
////
////        // Request option for Glide
////        option = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round_challenge).error(R.drawable.bg_round_challenge);
////
////    }

    public GridViewAdapter(List<Model_Berita> mData) {
        this.mData = mData;
    }


    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.grid_berita,parent,false) ;
        /*final MyViewHolder viewHolder = new MyViewHolder(view) ;*/
        /*viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });*/




        return new GridViewHolder(view);


    }


    @Override
    public void onBindViewHolder (final GridViewHolder holder, int position){

        final Model_Berita model_berita = mData.get(position);

        /* holder.view_container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animations));
         */
        Glide.with(holder.itemView.getContext()).load(mData.get(position).getImg()).apply(option).into(holder.img_thumbnail);
        holder.tv_judul.setText(mData.get(position).getJudul());
        holder.tv_deskripsi.setText(mData.get(position).getDeskripsi());

     /*   holder.tv_suka.setText(mData.get(position).getSuka());
        holder.tv_bagi.setText(mData.get(position).getBagi());
        holder.tv_gabung.setText(mData.get(position).getGabung());*/

        holder.card_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, MainActivity.class);
                i.putExtra("judul",model_berita.getJudul());
                i.putExtra("deskripsi",model_berita.getDeskripsi());
                i.putExtra("img",model_berita.getImg());
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

    public static class GridViewHolder extends RecyclerView.ViewHolder

    {

        RecyclerView recyclerView;
        TextView tv_judul ;
     /*   public MyViewHolder(TextView itemView){
            super(itemView);
            tv_judul = itemView;
        }*/


        TextView tv_deskripsi ;
        TextView tv_gabung;
        TextView tv_suka;
        TextView tv_bagi;
        ImageView img_thumbnail;
        Button btn_selengkapnya;
        CardView card_berita;





        public GridViewHolder(View itemView) {
            super(itemView);

            tv_judul = itemView.findViewById(R.id.tv_jd_berita_grid);
            tv_deskripsi = itemView.findViewById(R.id.tv_desk_berita_grid);
            btn_selengkapnya = itemView.findViewById(R.id.btn_selengkapnya);
//            card_berita = itemView.findViewById(R.id.cv_berita_grid);
         /*   tv_gabung = itemView.findViewById(R.id.tv_gabung);
            tv_suka = itemView.findViewById(R.id.tv_suka);
            tv_bagi = itemView.findViewById(R.id.tv_bagi);*/
            img_thumbnail = itemView.findViewById(R.id.img_berita_grid);

        }


    }

    /*public void updateList(List<Model_Challenge> newList){
        mData = new ArrayList<>();
        mData.addAll(newList);
        notifyDataSetChanged();


    }*/
}

