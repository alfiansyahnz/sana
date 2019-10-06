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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.R;
import com.sana.beranda.komunitas.KomunitasFragment;
import com.sana.feature.komunitas.KomunitasActivity;
import com.sana.feature.komunitas.KomunitasTabLayout;
import com.sana.feature.komunitas.KomunitasTimelineActivity;
import com.sana.feature.komunitas.TimelineFragment;
import com.sana.models.Komunitas;

import java.util.List;


public class KomunitasAdapter extends RecyclerView.Adapter<KomunitasAdapter.KomunitasViewHolder> {

    private List<Komunitas> isi;
    private RequestOptions option;

    public KomunitasAdapter(KomunitasActivity komunitasActivity, List<Komunitas> isi) {
        /*this.mContext = mContext;*/
        this.isi = isi;

//        // Request option for Glide
    option = new RequestOptions().centerCrop().placeholder(R.drawable.rounded_rectangle_orange).error(R.drawable.rounded_rectangle_orange);

    }

    public KomunitasAdapter(KomunitasFragment komunitasFragment, List<Komunitas> isi) {
        this.isi = isi;

//        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.rounded_rectangle_orange).error(R.drawable.rounded_rectangle_orange);
    }


    @Override
    public KomunitasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = inflater.inflate(R.layout.model_komunitas,viewGroup,false) ;

        return new KomunitasViewHolder(view);
    }

    @Override
    public void onBindViewHolder (final KomunitasViewHolder komunitasViewHolder, int position){

        final Komunitas model_komunitas = isi.get(position);

        /* holder.view_container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animations));
         */
        Glide.with(komunitasViewHolder.itemView.getContext()).load(isi.get(position).getImage()).apply(option).into(komunitasViewHolder.img_komunitas);
        komunitasViewHolder.nama_komunitas.setText(isi.get(position).getNama());
        komunitasViewHolder.nama_admin.setText(isi.get(position).getAdmin());

        komunitasViewHolder.jml_anggota.setText(isi.get(position).getAnggota());

        komunitasViewHolder.btn_bergabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent i = new Intent(mContext, KomunitasTabLayout.class);
                i.putExtra("nama_komunitas",model_komunitas.getNama());
                i.putExtra("nama_admin",model_komunitas.getAdmin());
                i.putExtra("jml_anggota",model_komunitas.getAnggota());
                i.putExtra("img_komunitas",model_komunitas.getImage());
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
        return isi.size();
    }

    public static class KomunitasViewHolder extends RecyclerView.ViewHolder {

        TextView nama_komunitas;
        TextView nama_admin;
        TextView jml_anggota;
        ImageView img_komunitas;
        RelativeLayout komunitas_layout;
        Button btn_bergabung;
        LinearLayout view_container;

        public KomunitasViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.bg_komunitas);
            nama_komunitas = itemView.findViewById(R.id.nama_komunitas);
            nama_admin = itemView.findViewById(R.id.nama_admin);
            jml_anggota = itemView.findViewById(R.id.jml_anggota);
            img_komunitas = itemView.findViewById(R.id.img_komunitas);
            komunitas_layout = itemView.findViewById(R.id.komunitas_layout);
            btn_bergabung = itemView.findViewById(R.id.btn_bergabung);

        }
    }
}
