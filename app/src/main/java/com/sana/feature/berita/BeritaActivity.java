package com.sana.feature.berita;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.sana.R;
import com.sana.adapter.BeritaAdapter;
import com.sana.models.Model_Berita;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BeritaActivity extends AppCompatActivity{

    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Model_Berita> mberita = new ArrayList<>()  ;
    private RecyclerView recyclerView ;
    private BeritaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);

        getSupportActionBar().setTitle("Berita");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerTemp);
        /*adapter = new ChallengeAdapter(mData);*/



        /*LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_animation_slide_right);
        recyclerView.setLayoutAnimation(animationController);*/
        jsonrequestberita();





    }


    private void jsonrequestberita() {

        //private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json" ;
        String JSON_URL = "https://lanuginose-numbers.000webhostapp.com/berita/index.php";
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
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
                        mberita.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(mberita);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(BeritaActivity.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Model_Berita> mData) {


        adapter = new BeritaAdapter(this,mData) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void runLayoutAnimation(RecyclerView recyclerView){
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_slide_right);

        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu, menu);


        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }




   /* @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }*/

   /* @Override
    public boolean onQueryTextChange(String newText) {

        String userInput = newText.toLowerCase();
        List<Model_Challenge> newList = new ArrayList<>();

       *//* for (Model_Challenge name :mData)
        {
            if (name.toLowerCase().contains(userInput))
            {
                newList.add(name);
            }
        }*//*

        adapter.updateList(newList);

        return true;
    }*/
}
