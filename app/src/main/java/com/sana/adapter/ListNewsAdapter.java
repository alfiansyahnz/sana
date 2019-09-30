package com.sana.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.sana.Common.ISO8601Parse;
import com.sana.Interface.ItemClickListener;
import com.sana.R;
import com.sana.feature.berita.DetailArticle;
import com.sana.models.Article;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsAdapter.ListNewsViewHolder>{
    private List<Article> articleList;
    private Context context;

    public ListNewsAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

class ListNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    ItemClickListener itemClickListener;

    TextView article_title;
    RelativeTimeTextView article_time;
    CircleImageView article_image;

    public ListNewsViewHolder (View itemView){
        super(itemView);
        article_image = (CircleImageView)itemView.findViewById(R.id.article_image);
        article_title = (TextView)itemView.findViewById(R.id.article_title);
        article_time = (RelativeTimeTextView) itemView.findViewById(R.id.article_time);

        itemView.setOnClickListener(this);                  

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick (View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}



    @NonNull
    @Override
    public ListNewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.news_layout,viewGroup,false);
        return new ListNewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListNewsViewHolder holder, int i) {

        Glide.with(context)
                .load(articleList.get(i).getUrlToImage())
                .into(holder.article_image);

        if(articleList.get(i).getTitle().length() > 65)
            holder.article_title.setText(articleList.get(i).getTitle().substring(0,65)+"...");
        else
            holder.article_title.setText(articleList.get(i).getTitle());

        Date date=null;
        try{
            date = ISO8601Parse.parse(articleList.get(i).getPublishedAt());
        }catch (ParseException ex)
        {
            ex.printStackTrace();
        }
        holder.article_time.setReferenceTime(date.getTime());

        //set event click
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                //code late
                Intent detail = new Intent(context, DetailArticle.class);
                detail.putExtra("webURL",articleList.get(position).getUrl());
                context.startActivity(detail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
