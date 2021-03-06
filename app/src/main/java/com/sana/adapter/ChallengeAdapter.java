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

import com.sana.R;
import com.sana.feature.challenge.ChallengeActivity;
import com.sana.feature.challenge.DetailChallenge;
import com.sana.models.Challenge;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by Aws on 11/03/2018.
 */

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.MyViewHolder> implements Filterable {

    /*private Context mContext ;*/
    private List<Challenge> mData ;
    private List<Challenge> exampleListFull;
    private RequestOptions option;

   /* private ItemClickCallBack itemClickCallBack;

    public interface ItemClickCallBack{
        void onItemClick(View v, int p);

        void onSecondaryClick(int p)
    }*/


    public ChallengeAdapter(ChallengeActivity challengeActivity, List<Challenge> mData) {
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
    public void onBindViewHolder (final ChallengeAdapter.MyViewHolder holder, int position){

        final Challenge model_challenge = mData.get(position);

        /* holder.view_container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animations));
         */
        Glide.with(holder.itemView.getContext()).load(mData.get(position).getImg()).apply(option).into(holder.img_thumbnail);
        holder.tv_judul.setText(mData.get(position).getJudul());
        holder.tv_deskripsi.setText(mData.get(position).getDeskripsi());

        holder.tv_suka.setText(mData.get(position).getSuka());
        holder.tv_bagi.setText(mData.get(position).getBagi());
        holder.tv_gabung.setText(mData.get(position).getGabung());

        holder.btn_selengkapnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, DetailChallenge.class);
                i.putExtra("judul",model_challenge.getJudul());
                i.putExtra("deskripsi",model_challenge.getDeskripsi());
                i.putExtra("img",model_challenge.getImg());
                i.putExtra("suka",model_challenge.getSuka());
                i.putExtra("bagi",model_challenge.getBagi());
                i.putExtra("gabung", model_challenge.getGabung());
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

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Challenge> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(exampleListFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Challenge item : exampleListFull){
                    if (item.getJudul().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mData.clear();
            mData.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };


    public static class MyViewHolder extends RecyclerView.ViewHolder

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
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.bg_challenge);
            tv_judul = itemView.findViewById(R.id.tv_challenge_judul);

            tv_deskripsi = itemView.findViewById(R.id.tv_challenge_desc);
            btn_selengkapnya = itemView.findViewById(R.id.btn_selengkapnya);
            tv_gabung = itemView.findViewById(R.id.tv_gabung);
            tv_suka = itemView.findViewById(R.id.tv_suka);
            tv_bagi = itemView.findViewById(R.id.tv_bagi);
            img_thumbnail = itemView.findViewById(R.id.img_challenge);
            recyclerView = itemView.findViewById(R.id.recyclerTemp);

        }


    }

    /*public void updateList(List<Model_Challenge> newList){
        mData = new ArrayList<>();
        mData.addAll(newList);
        notifyDataSetChanged();


    }*/
}
