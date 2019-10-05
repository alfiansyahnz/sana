package com.sana.feature.komunitas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.R;


public class DetailKomunitasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_komunitas);

//        getSupportActionBar().setTitle("Komunitas");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//        String judul = getIntent().getStringExtra("judul");
//        String deskripsi = getIntent().getStringExtra("deskripsi");
//        String img = getIntent().getStringExtra("img");
//
//        TextView tv_judul = findViewById(R.id.judul);
//        TextView tv_desk = findViewById(R.id.detail_deskripsi);
//        ImageView img_challenge = findViewById(R.id.img_detail);
//
//        tv_judul.setText(judul);
//        tv_desk.setText(deskripsi);
//
//        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round).error(R.drawable.bg_round);
//
//        Glide.with(this).load(img).apply(requestOptions).into(img_challenge);


    }
}
