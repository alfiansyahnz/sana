package com.sana.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sana.R;
import com.sana.models.Donasi;

import java.util.ArrayList;

public class DonasiAdapter extends RecyclerView.Adapter<DonasiAdapter.DonasiViewHolder> {
    private ArrayList<Donasi> mDonasiArrayList;
    public DonasiAdapter(ArrayList<Donasi> isi) {
        this.mDonasiArrayList = isi;
    }
    @NonNull
    @Override
    public DonasiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_list_donasi, viewGroup, false);
        return new DonasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonasiViewHolder donasiViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DonasiViewHolder extends RecyclerView.ViewHolder {
        public DonasiViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
