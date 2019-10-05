package com.sana.feature.donasi;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.R;
import com.sana.adapter.TabAdapter;

public class DetailDonasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_donasi);

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new DonasiFragment(), "Donasi");
        adapter.addFragment(new VolunteerFragment(), "Volunteer");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        Toolbar toolbar = findViewById(R.id.toolbardonasi);
//        setSupportActionBar(toolbar);
//        if(getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//        }

//        String judul = getIntent().getStringExtra("judul");
//        String deskripsi = getIntent().getStringExtra("deskripsi");
          String gambar = getIntent().getStringExtra("gambar");
//        String user = getIntent().getStringExtra("user");
//        String hari = getIntent().getStringExtra("hari");
//        String jumlah = getIntent().getStringExtra("jumlah");
//        String lokasi = getIntent().getStringExtra("lokasi");
//        String tanggal = getIntent().getStringExtra("tanggal");
//        String join = getIntent().getStringExtra("joinvol");
//
//        TextView tv_judul_don = findViewById(R.id.tv_donasi_judul);
//        TextView tv_user_don = findViewById(R.id.tv_donasi_user);
//        TextView tv_hari_don = findViewById(R.id.tv_donasi_hari);
//        TextView tv_jumlah_don = findViewById(R.id.tv_donasi_jumlah);
//        TextView tv_lokasi_don = findViewById(R.id.tv_donasi_lokasi);
//        TextView tv_join_don = findViewById(R.id.tv_donasi_join);
//        TextView tv_desk_don = findViewById(R.id.tv_donasi_deskripsi);
        ImageView img_donasi_don = findViewById(R.id.image_view_detail_donasi);
//
//        TextView tv_judul_vol = findViewById(R.id.tv_volunteer_judul);
//        TextView tv_user_vol = findViewById(R.id.tv_volunteer_user);
//        TextView tv_hari_vol = findViewById(R.id.tv_volunteer_hari);
//        TextView tv_tanggal_vol = findViewById(R.id.tv_volunteer_tanggal);
//        TextView tv_lokasi_vol = findViewById(R.id.tv_volunteer_lokasi);
//        TextView tv_join_vol = findViewById(R.id.tv_volunteer_join);
//        TextView tv_desk_vol = findViewById(R.id.tv_volunteer_deskripsi);
//
//
//        tv_judul_don.setText(judul);
//        tv_desk_don.setText(deskripsi);
//        tv_user_don.setText(user);
//        tv_hari_don.setText(hari);
//        tv_jumlah_don.setText(jumlah);
//        tv_lokasi_don.setText(lokasi);
//        tv_join_don.setText(join);
//
//        tv_judul_vol.setText(judul);
//        tv_desk_vol.setText(deskripsi);
//        tv_user_vol.setText(user);
//        tv_hari_vol.setText(hari);
//        tv_tanggal_vol.setText(tanggal);
//        tv_lokasi_vol.setText(lokasi);
//        tv_join_vol.setText(join);
//
//
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round).error(R.drawable.bg_round);

        Glide.with(this).load(gambar).apply(requestOptions).into(img_donasi_don);
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
