package com.sana.feature.komunitas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment{


    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);

        String nama_komunitas = getActivity().getIntent().getStringExtra("nama_komunitas");
        String img_komunitas = getActivity().getIntent().getStringExtra("img_komunitas");
        String jml_anggota = getActivity().getIntent().getStringExtra("jml_anggota");


        TextView nama_komunitastxt = view.findViewById(R.id.judul_kom);
        TextView jml_anggotatxt = view.findViewById(R.id.jmlKom);
        ImageView img_komunitasvw = view.findViewById(R.id.imgGambreng);

        nama_komunitastxt.setText(nama_komunitas);
        jml_anggotatxt.setText(jml_anggota);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round).error(R.drawable.bg_round);

        Glide.with(this).load(img_komunitas).apply(requestOptions).into(img_komunitasvw);

        return view;
    }

}
