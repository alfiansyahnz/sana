package com.sana.FirebaseParticle;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.sana.R;

public class NoNetwork extends AppCompatActivity {

    ImageView gambar;
    Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_network);

        gambar = findViewById(R.id.gambar);
        btnConnect = findViewById(R.id.btnConnect);

        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekKoneksi();
            }
        });

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
}