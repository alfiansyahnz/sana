package com.sana.feature.donasi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.sana.R;
import com.sana.adapter.DonasiAdapter;
import com.sana.models.Donasi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DonasiActivity extends AppCompatActivity {

    private List<Donasi> mData = new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi);

        this.getSupportActionBar().setTitle("Donasi");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerdonasi);

        jsonrequest();
    }

    private void jsonrequest() {

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

                        mData.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(mData);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(DonasiActivity.this);
        requestQueue.add(request);


    }

    private void setuprecyclerview(List<Donasi> mData) {


        DonasiAdapter adapter = new DonasiAdapter(mData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void runLayoutAnimation(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_right);

        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}

