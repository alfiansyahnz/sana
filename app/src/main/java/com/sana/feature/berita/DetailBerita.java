package com.sana.feature.berita;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.sana.R;
import com.sana.adapter.GridViewAdapter;

import com.sana.models.Model_Berita;

import java.util.ArrayList;
import java.util.List;

public class DetailBerita extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Model_Berita> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_detail_berita);
//        initialize();

        getSupportActionBar().setTitle("Berita");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        String judul = getIntent().getStringExtra("judul");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String img = getIntent().getStringExtra("img");
        /*Integer suka = getIntent().getExtras().getInt("suka");
        Integer bagi = getIntent().getExtras().getInt("bagi");
        Integer gabung = getIntent().getExtras().getInt("gabung");*/


/*
ChallengeAdapter recyclerViewAdapter = findViewById(R.id.recyclerTemp);
        recyclerViewAdapter.
*/

        TextView tv_judul = findViewById(R.id.judul_berita);
        TextView tv_desk = findViewById(R.id.detail_berita);
        ImageView img_berita = findViewById(R.id.img_detail_berita);

        tv_judul.setText(judul);
        tv_desk.setText(deskripsi);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round).error(R.drawable.bg_round);

        Glide.with(this).load(img).apply(requestOptions).into(img_berita);

       /* recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        GridViewAdapter gridviewAdapter = new GridViewAdapter(mData);
        recyclerView.setAdapter(gridviewAdapter);
*/
    }
//
//    private void initialize(){
//        recyclerView= (RecyclerView)findViewById(R.id.cv_berita_grid);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setAdapter(new GridViewAdapter(mData));
//
//    }

    public void berbagi() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/play");
        intent.putExtra(Intent.EXTRA_SUBJECT, "SANA");
        String pesan = "\nSaya merekomendasikan aplikasi ini ke sana\n";
        intent.putExtra(Intent.EXTRA_TEXT, pesan);
        startActivity(intent.createChooser(intent, "Pilih Salah Satu "));
    }

    public void simpan() {
        Toast.makeText(this, "Anda Memilih Simpan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.berbagi:
                berbagi();
                break;
            case R.id.simpan:
                simpan();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}


