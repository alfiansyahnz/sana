package com.sana.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sana.Common.Common;
import com.sana.Interface.IconBetterIdeaService;
import com.sana.Interface.ItemClickListener;
import com.sana.R;
import com.sana.feature.berita.ListNews;
import com.sana.models.IconBetterIdea;
import com.sana.models.WebSite;


import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSourceAdapter extends RecyclerView.Adapter<ListSourceAdapter.ListSourceViewHolder>{
    private Context context;
    private WebSite webSite;

    private IconBetterIdeaService mService;

    public ListSourceAdapter(Context context, WebSite webSite) {
        this.context = context;
        this.webSite = webSite;

        mService = Common.getIconService();
    }

class ListSourceViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener
{
    ItemClickListener itemClickListener;

    TextView source_title;
    CircleImageView source_image;

    public ListSourceViewHolder(@NonNull View itemView) {
        super(itemView);

        source_image = (CircleImageView) itemView.findViewById(R.id.source_image);
        source_title = (TextView) itemView.findViewById(R.id.source_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}



    @NonNull
    @Override
    public ListSourceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.source_layout,viewGroup,false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListSourceViewHolder listSourceViewHolder, int i) {

        StringBuilder iconBetterAPI = new StringBuilder("");

        mService.getIconUrl(iconBetterAPI.toString())
                .enqueue(new Callback<IconBetterIdea>() {
                    @Override
                    public void onResponse(Call<IconBetterIdea> call, Response<IconBetterIdea> response) {
                        if (response.body().getIcons().size() > 0)
                        {
                            Glide.with(context)
                                    .load(response.body().getIcons().get(0).getUrl())
                                    .into(listSourceViewHolder.source_image);
                        }
                    }

                    @Override
                    public void onFailure(Call<IconBetterIdea> call, Throwable t) {

                    }
                });

        listSourceViewHolder.source_title.setText(webSite.getSources().get(i).getName());
        listSourceViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, ListNews.class);
                intent.putExtra("source",webSite.getSources().get(position).getId());
                //this property in remove in news api ver2

                intent.putExtra("sortBy", (Parcelable) webSite.getSources().get(position)); // get Default sortBy method
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return webSite.getSources().size();
    }
}
