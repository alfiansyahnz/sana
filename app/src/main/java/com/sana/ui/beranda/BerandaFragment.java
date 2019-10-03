package com.sana.ui.beranda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ImageButton;


import com.sana.R;
import com.sana.feature.berita.BeritaActivity;
import com.sana.feature.challenge.ChallengeActivity;
import com.sana.feature.donasi.DonasiActivity;
import com.sana.feature.event.EventActivity;
import com.sana.feature.komunitas.Komunitas;
import com.sana.feature.lapor.LaporActivity;
import com.sana.ui.riwayat.RiwayatFragment;

public class BerandaFragment extends Fragment {


    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        ImageButton ib_donasi = view.findViewById(R.id.ib_donasi);
        ib_donasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity(), DonasiActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        ImageButton ib_challenge = view.findViewById(R.id.ib_challenge);
        ib_challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity(), ChallengeActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        ImageButton ib_event = view.findViewById(R.id.ib_event);
        ib_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity(), EventActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        ImageButton ib_lapor = view.findViewById(R.id.ib_lapor);
        ib_lapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity(), LaporActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        ImageButton ib_berita = view.findViewById(R.id.ib_berita);
        ib_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity(), BeritaActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });



        setHasOptionsMenu(true);
        Toolbar toolbar = view.findViewById(R.id.toolbarberanda);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_action_beranda, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i;
        switch (item.getItemId()) {
            case R.id.mKomunitas:
                i = new Intent(getActivity(), Komunitas.class);
                startActivity(i);
                return true;

            case R.id.mNotifikasi:
                i = new Intent(getActivity(), RiwayatFragment.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}