package com.sana.feature.donasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.MainActivity;
import com.sana.R;

public class DonasiProsesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi_proses);
        this.getSupportActionBar().setTitle("Proses Donasi");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);


        String judul = getIntent().getStringExtra("judul");
        String gambar = getIntent().getStringExtra("gambar");

        TextView tv_donasi_proses_judul = findViewById(R.id.tv_donasi_proses_judul);
        ImageView img_donasi_proses_judul = findViewById(R.id.iv_donasi_proses);

        tv_donasi_proses_judul.setText(judul);
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round).error(R.drawable.bg_round);

        Glide.with(this).load(gambar).apply(requestOptions).into(img_donasi_proses_judul);
        Button btn_donasi = findViewById(R.id.button_donasi_now);
        btn_donasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(DonasiProsesActivity.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
