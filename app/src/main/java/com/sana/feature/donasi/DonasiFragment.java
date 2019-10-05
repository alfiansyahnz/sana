package com.sana.feature.donasi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.R;
import com.sana.adapter.DonasiAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonasiFragment extends Fragment {

    public DonasiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_donasi, container, false);
        String judul = getActivity().getIntent().getStringExtra("judul");
        String deskripsi = getActivity().getIntent().getStringExtra("deskripsi");
        String img = getActivity().getIntent().getStringExtra("img");
        String user = getActivity().getIntent().getStringExtra("user");
        String hari = getActivity().getIntent().getStringExtra("hari");
        String jumlah = getActivity().getIntent().getStringExtra("jumlah");
        String lokasi = getActivity().getIntent().getStringExtra("lokasi");
        String join = getActivity().getIntent().getStringExtra("joinvol");

        TextView tv_judul_don = view.findViewById(R.id.tv_donasi_judul);
        TextView tv_user_don = view.findViewById(R.id.tv_donasi_user);
        TextView tv_hari_don = view.findViewById(R.id.tv_donasi_hari);
        TextView tv_jumlah_don = view.findViewById(R.id.tv_donasi_jumlah);
        TextView tv_lokasi_don = view.findViewById(R.id.tv_donasi_lokasi);
        TextView tv_join_don = view.findViewById(R.id.tv_donasi_join);
        TextView tv_desk_don = view.findViewById(R.id.tv_donasi_deskripsi);

        tv_judul_don.setText(judul);
        tv_desk_don.setText(deskripsi);
        tv_user_don.setText(user);
        tv_hari_don.setText(hari);
        tv_jumlah_don.setText(jumlah);
        tv_lokasi_don.setText(lokasi);
        tv_join_don.setText(join);

        Button button = view.findViewById(R.id.button_donasi);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                if (v.getId() == R.id.button_donasi) {
                    Intent intent = new Intent(getActivity(), DonasiProsesActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

}
