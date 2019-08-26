package com.sana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailChallenge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_challenge);


        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        String judul = getIntent().getStringExtra("judul");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String img = getIntent().getStringExtra("img");
        /*Integer suka = getIntent().getExtras().getInt("suka");
        Integer bagi = getIntent().getExtras().getInt("bagi");
        Integer gabung = getIntent().getExtras().getInt("gabung");*/


/*
RecyclerViewAdapter recyclerViewAdapter = findViewById(R.id.recyclerTemp);
        recyclerViewAdapter.
*/

        TextView tv_judul = findViewById(R.id.judul);
        TextView tv_desk = findViewById(R.id.detail_deskripsi);
        ImageView img_challenge = findViewById(R.id.img_detail);

        tv_judul.setText(judul);
        tv_desk.setText(deskripsi);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round).error(R.drawable.bg_round);

        Glide.with(this).load(img).apply(requestOptions).into(img_challenge);

    }

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

