package com.sana.feature.event;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.R;

import org.w3c.dom.Text;

public class DetailEvent extends AppCompatActivity {
    ImageView gambar;
    Button btnConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);


        getSupportActionBar().setTitle("Detail Event");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        String judul = getIntent().getStringExtra("judul");
        String tempat = getIntent().getStringExtra("tempat");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String img = getIntent().getStringExtra("img_event");
        String tanggal = getIntent().getStringExtra("tanggal");
        String hari = getIntent().getStringExtra("hari");
        String bulan = getIntent().getStringExtra("bulan");
        String tahun = getIntent().getStringExtra("tahun");
        String waktu = getIntent().getStringExtra("waktu");
        /*Integer suka = getIntent().getExtras().getInt("suka");
        Integer bagi = getIntent().getExtras().getInt("bagi");
        Integer gabung = getIntent().getExtras().getInt("gabung");*/


/*
ChallengeAdapter recyclerViewAdapter = findViewById(R.id.recyclerTemp);
        recyclerViewAdapter.
*/

        TextView tv_judul = findViewById(R.id.judul_event);
        TextView tv_desk = findViewById(R.id.detail_deskripsi_event);
        ImageView img_event = findViewById(R.id.img_detail);
        TextView tv_tangggal = findViewById(R.id.tv_tanggal);
        TextView tv_hari = findViewById(R.id.tv_hari);
        TextView tv_bulan = findViewById(R.id.tv_bulan);
        TextView tv_tahun = findViewById(R.id.tv_tahun);
        TextView tv_waktu = findViewById(R.id.tv_waktu);
        TextView tv_tempat = findViewById(R.id.tv_tempat);


        tv_waktu.setText(waktu);
        tv_bulan.setText(bulan);
        tv_hari.setText(hari);
        tv_tangggal.setText(tanggal);
        tv_tahun.setText(tahun);
        tv_judul.setText(judul);
        tv_desk.setText(deskripsi);
        tv_tempat.setText(tempat);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round).error(R.drawable.bg_round);

        Glide.with(this).load(img).apply(requestOptions).into(img_event);



    }

    private void cekKoneksi() {
        boolean wifiConnected;
        boolean mobileConnected;
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()){ //connected with either mobile or wifi
            wifiConnected = activeInfo.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = activeInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            if (wifiConnected){ //wifi connected
                gambar.setVisibility(View.GONE);
                btnConnect.setVisibility(View.GONE);
            }
            else if (mobileConnected){ //mobile data connected
                gambar.setVisibility(View.GONE);
                btnConnect.setVisibility(View.GONE);
            }
        }
        else { //no internet connection
            gambar.setVisibility(View.VISIBLE);
            btnConnect.setVisibility(View.VISIBLE);
        }
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

    public void beli(View view)
    {Toast.makeText(this,"Selamat Anda telah membeli Tiket Event", Toast.LENGTH_LONG).show();}



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