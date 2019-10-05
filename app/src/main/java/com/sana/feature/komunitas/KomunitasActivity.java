package com.sana.feature.komunitas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.sana.R;
import com.sana.adapter.KomunitasAdapter;
import com.sana.models.Komunitas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

    public class KomunitasActivity extends AppCompatActivity {

        //private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json" ;
        private final String JSON_URL = "https://lanuginose-numbers.000webhostapp.com/komunitas/index.php";
        private JsonArrayRequest request ;
        private RequestQueue requestQueue ;
        private List<Komunitas> isi ;
        private RecyclerView recyclerView ;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_komunitas);

            getSupportActionBar().setTitle("Komunitas");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            isi = new ArrayList<>() ;
            recyclerView = findViewById(R.id.recyclerview_komunitas);

        /*LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_slide_right);
        recyclerView.setLayoutAnimation(animationController);*/
            jsonrequest();





        }

        private void jsonrequest() {

            request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    JSONObject jsonObject  = null ;

                    for (int i = 0 ; i < response.length(); i++ ) {


                        try {
                            jsonObject = response.getJSONObject(i) ;
                            Komunitas model = new Komunitas() ;
                            model.setId(jsonObject.getString("id"));
                            model.setNama(jsonObject.getString("nama_komunitas"));
                            model.setAdmin(jsonObject.getString("nama_admin"));
                            model.setAnggota(jsonObject.getString("jml_anggota"));
                            model.setImage(jsonObject.getString("img_komunitas"));
                            isi.add(model);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                    setuprecyclerview(isi);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


            requestQueue = Volley.newRequestQueue(KomunitasActivity.this);
            requestQueue.add(request) ;


        }

        private void setuprecyclerview(List<Komunitas> isi) {


            KomunitasAdapter komunitasAdapter = new KomunitasAdapter (this,isi) ;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(komunitasAdapter);

        }

//        private void runLayoutAnimation(RecyclerView recyclerView){
//            Context context = recyclerView.getContext();
//            LayoutAnimationController layoutAnimationController =
//                    AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_slide_right);
//
//            recyclerView.setLayoutAnimation(layoutAnimationController);
//            recyclerView.getAdapter().notifyDataSetChanged();
//            recyclerView.scheduleLayoutAnimation();
//
//
//        }

        @Override
        public boolean onSupportNavigateUp() {
            onBackPressed();
            return true;
        }

//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//
//            getMenuInflater().inflate(R.menu.search_menu, menu);
//
//
//
//            return super.onCreateOptionsMenu(menu);
//        }
    }
