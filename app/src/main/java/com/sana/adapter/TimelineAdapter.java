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
import com.sana.feature.komunitas.KomunitasActivity;
import com.sana.feature.komunitas.KomunitasTabLayout;
import com.sana.feature.komunitas.TimelineFragment;
import com.sana.feature.komunitas.Timeline_Post_Activity;
import com.sana.models.Komunitas;
import com.sana.models.Timeline_Post;

import org.w3c.dom.Text;

import java.util.List;


public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {

    private List<Timeline_Post> isiPostTimeline;
    private RequestOptions option;

    public TimelineAdapter(Timeline_Post_Activity timeline_post_Activity, List<Timeline_Post> isi) {
        /*this.mContext = mContext;*/
        this.isiPostTimeline = isi;

//        // Request option for Glide
    option = new RequestOptions().centerCrop().placeholder(R.drawable.rounded_rectangle_orange).error(R.drawable.rounded_rectangle_orange);

    }

    public TimelineAdapter(TimelineFragment timelineFragment, List<Timeline_Post> mData) {

    }


    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        view = inflater.inflate(R.layout.model_post,viewGroup,false) ;

        return new TimelineViewHolder(view);
    }

    @Override
    public void onBindViewHolder (final TimelineViewHolder timelineViewHolder, int position){

        final Timeline_Post model_timeline = isiPostTimeline.get(position);

        /* holder.view_container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animations));
         */
        Glide.with(timelineViewHolder.itemView.getContext()).load(isiPostTimeline.get(position).getPostImg()).apply(option).into(timelineViewHolder.postImg);
        timelineViewHolder.nameUser.setText(isiPostTimeline.get(position).getNameUser());
        timelineViewHolder.waktuPost.setText(isiPostTimeline.get(position).getWaktuPost());
        timelineViewHolder.isiPost.setText(isiPostTimeline.get(position).getIsiPost());
        timelineViewHolder.komentarPost.setText(isiPostTimeline.get(position).getKomentarPost());


        // Load Image from the internet and set it into Imageview using Glide


    }

    @Override
    public int getItemCount() {
        return isiPostTimeline.size();
    }

    public static class TimelineViewHolder extends RecyclerView.ViewHolder {

        TextView nameUser;
        TextView waktuPost;
        TextView komentarPost;
        TextView isiPost;
        ImageView postImg;
        RelativeLayout timelineRelative;
        LinearLayout postTimelineLayout;

        public TimelineViewHolder(View itemView) {
            super(itemView);

            postTimelineLayout = itemView.findViewById(R.id.postTimelineLayout);
            isiPost = itemView.findViewById(R.id.isiPost);
            nameUser = itemView.findViewById(R.id.nameUser);
            waktuPost = itemView.findViewById(R.id.waktuPost);
            postImg = itemView.findViewById(R.id.postImg);
            komentarPost = itemView.findViewById(R.id.komentarPost);
            timelineRelative = itemView.findViewById(R.id.timelineRelative);

        }
    }
}
