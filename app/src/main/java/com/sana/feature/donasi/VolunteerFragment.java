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


public class VolunteerFragment extends Fragment {


    public VolunteerFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volunteer, container, false);

        String judul = getActivity().getIntent().getStringExtra("judul");
        String deskripsi = getActivity().getIntent().getStringExtra("deskripsi");
        String user = getActivity().getIntent().getStringExtra("user");
        String hari = getActivity().getIntent().getStringExtra("hari");
        String tanggal = getActivity().getIntent().getStringExtra("tanggal");
        String lokasi = getActivity().getIntent().getStringExtra("lokasi");
        String join = getActivity().getIntent().getStringExtra("joinvol");


        TextView tv_judul_vol = view.findViewById(R.id.tv_volunteer_judul);
        TextView tv_user_vol =  view.findViewById(R.id.tv_volunteer_user);
        TextView tv_hari_vol =  view.findViewById(R.id.tv_volunteer_hari);
        TextView tv_tanggal_vol =  view.findViewById(R.id.tv_volunteer_tanggal);
        TextView tv_lokasi_vol =  view.findViewById(R.id.tv_volunteer_lokasi);
        TextView tv_join_vol =  view.findViewById(R.id.tv_volunteer_join);
        TextView tv_desk_vol =  view.findViewById(R.id.tv_volunteer_deskripsi);

        tv_judul_vol.setText(judul);
        tv_desk_vol.setText(deskripsi);
        tv_user_vol.setText(user);
        tv_hari_vol.setText(hari);
        tv_tanggal_vol.setText(tanggal);
        tv_lokasi_vol.setText(lokasi);
        tv_join_vol.setText(join);

        Button button = view.findViewById(R.id.button_volunteer);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                if (v.getId() == R.id.button_volunteer) {
                    Intent intent = new Intent(getActivity(), FormVolunteerActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

}
