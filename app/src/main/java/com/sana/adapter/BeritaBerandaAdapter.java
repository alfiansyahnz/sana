package com.sana.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.MainActivity;
import com.sana.R;
import com.sana.beranda.beranda.BerandaFragment;
import com.sana.feature.berita.DetailBerita;
import com.sana.models.Model_Berita;

import java.util.ArrayList;
import java.util.List;

public class BeritaBerandaAdapter extends RecyclerView.Adapter<BeritaBerandaAdapter.MyViewHolder>{

    /*private Context mContext ;*/
    private List<Model_Berita> mData ;
    private List<Model_Berita> exampleListFull;
    private RequestOptions option;

   /* private ItemClickCallBack itemClickCallBack;

    public interface ItemClickCallBack{
        void onItemClick(View v, int p);

        void onSecondaryClick(int p)
    }*/


    public BeritaBerandaAdapter(BerandaFragment berandaFragment, List<Model_Berita> mData) {
        /*this.mContext = mContext;*/
        this.mData = mData;
        exampleListFull = new ArrayList<>(mData);

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round_challenge).error(R.drawable.bg_round_challenge);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.model_berita_beranda,parent,false) ;
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

        final Model_Berita model_berita = mData.get(position);

        /* holder.view_container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animations));
         */
        Glide.with(holder.itemView.getContext()).load(mData.get(position).getImg()).apply(option).into(holder.img_thumbnail);
        holder.tv_judul.setText(mData.get(position).getJudul());
        holder.tv_deskripsi.setText(mData.get(position).getDeskripsi());
        holder.btn_selengkapnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, DetailBerita.class);
                i.putExtra("judul",model_berita.getJudul());
                i.putExtra("deskripsi",model_berita.getDeskripsi());
                i.putExtra("img",model_berita.getImg());
               /* i.putExtra("suka",model_challenge.getSuka());
                i.putExtra("bagi",model_challenge.getBagi());
                i.putExtra("gabung", model_challenge.getGabung());*/
               /* i.putExtra("anime_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());*/

                mContext.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder

    {

        RecyclerView recyclerView;
        TextView tv_judul ;
     /*   public MyViewHolder(TextView itemView){
            super(itemView);
            tv_judul = itemView;
        }*/


        TextView tv_deskripsi ;
        ImageView img_thumbnail;
        ImageView img_thumbnail1;
        Button btn_selengkapnya;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.bg_challenge);
            tv_judul = itemView.findViewById(R.id.tv_berita_judul_beranda);

            tv_deskripsi = itemView.findViewById(R.id.tv_berita_desc_beranda);
            btn_selengkapnya = itemView.findViewById(R.id.btn_selengkapnya_berita_beranda);
            img_thumbnail = itemView.findViewById(R.id.img_berita_beranda);

            recyclerView = itemView.findViewById(R.id.rv_beritaberanda);

        }


    }

    /*public void updateList(List<Model_Challenge> newList){
        mData = new ArrayList<>();
        mData.addAll(newList);
        notifyDataSetChanged();


    }*/
}

