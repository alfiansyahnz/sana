package com.sana.beranda.beranda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageButton;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.sana.R;
import com.sana.feature.berita.BeritaActivity;
import com.sana.feature.challenge.ChallengeActivity;
import com.sana.adapter.BeritaBerandaAdapter;
import com.sana.adapter.DonasiBerandaAdapter;
import com.sana.feature.donasi.DonasiActivity;
import com.sana.feature.event.EventActivity;
import com.sana.feature.lapor.LaporActivity;
import com.sana.models.Donasi;
import com.sana.models.Komunitas;
import com.sana.beranda.riwayat.RiwayatFragment;
import com.sana.models.Model_Berita;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BerandaFragment extends Fragment {
    List<Model_Berita> mBerita = new ArrayList<>()  ;
    List<Donasi> mDonasi = new ArrayList<>();
    RecyclerView recyclerViewberita , recyclerViewdonasi;


    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        setHasOptionsMenu(true);
        Toolbar toolbar = view.findViewById(R.id.toolbarberanda);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        recyclerViewberita = view.findViewById(R.id.rv_beritaberanda);
        recyclerViewdonasi = view.findViewById(R.id.rv_donasiberanda);

        jsonrequestberita();
        jsonrequestdonasi();

        ImageButton ib_donasi = view.findViewById(R.id.img_donasi);
        ib_donasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity(), DonasiActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        ImageButton ib_challenge = view.findViewById(R.id.img_challenge);
        ib_challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity().getApplicationContext(), ChallengeActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        ImageButton ib_event = view.findViewById(R.id.img_event);
        ib_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity(), EventActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        ImageButton ib_lapor = view.findViewById(R.id.img_lapor);
        ib_lapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity().getApplicationContext(), LaporActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
        ImageButton ib_berita = view.findViewById(R.id.img_berita);
        ib_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity(), BeritaActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        Button btn_donasi = view.findViewById(R.id.button_daftar_donasi);
        btn_donasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity().getApplicationContext(), DonasiActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        Button btn_volunteer = view.findViewById(R.id.button_ikut_volunteer);
        btn_donasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(getActivity().getApplicationContext(), DonasiActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

        return view;
    }

    private void jsonrequestdonasi() {

        String JSON_URL = "https://lanuginose-numbers.000webhostapp.com/donasi/index.php";
        JsonArrayRequest request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {


                    try {
                        jsonObject = response.getJSONObject(i);
                        Donasi model = new Donasi();
                        model.setId(jsonObject.getString("id"));
                        model.setJudul(jsonObject.getString("judul"));
                        model.setDeskripsi(jsonObject.getString("deskripsi"));
                        model.setUser(jsonObject.getString("user"));
                        model.setHari(jsonObject.getString("hari"));
                        model.setGambar(jsonObject.getString("gambar"));
                        model.setJoin(jsonObject.getString("joinvol"));
                        model.setJumlah(jsonObject.getString("jumlah"));
                        model.setTanggal(jsonObject.getString("tanggal"));
                        model.setLokasi(jsonObject.getString("lokasi"));

                        mDonasi.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerviewdonasi(mDonasi);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);

    }


    private void jsonrequestberita() {
        String JSON_URL = "https://lanuginose-numbers.000webhostapp.com/berita/index.php";
        JsonArrayRequest request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Model_Berita model = new Model_Berita() ;
                        model.setId(jsonObject.getString("id"));
                        model.setJudul(jsonObject.getString("judul"));
                        model.setDeskripsi(jsonObject.getString("deskripsi"));
                        model.setImg(jsonObject.getString("img"));
                        mBerita.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                setuprecyclerviewberita(mBerita);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request) ;


    }

    private void setuprecyclerviewberita(List<Model_Berita> berita) {

        BeritaBerandaAdapter adapter = new BeritaBerandaAdapter(BerandaFragment.this,berita) ;
        recyclerViewberita.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewberita.setAdapter(adapter);

    }

    private void setuprecyclerviewdonasi(List<Donasi> donasi) {
        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        DonasiBerandaAdapter adapter = new DonasiBerandaAdapter(BerandaFragment.this,donasi);
        recyclerViewdonasi.setLayoutManager(layoutManager1);
        recyclerViewdonasi.setAdapter(adapter);

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