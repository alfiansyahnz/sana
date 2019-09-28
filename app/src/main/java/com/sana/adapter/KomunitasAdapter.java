package com.sana.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.sana.models.ListKomunitas;

import java.util.ArrayList;

public class KomunitasAdapter extends RecyclerView.Adapter<KomunitasAdapter.ViewHolder> {
    private ArrayList<ListKomunitas> komunitas;
    private Context context;

    public KomunitasAdapter(Context context, ArrayList<ListKomunitas> komunitas){
        this.context = context;
        this.komunitas = komunitas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
