package com.sana.feature.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.sana.R;
import com.sana.adapter.EventAdapter;

import com.sana.models.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {

    //private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json" ;
    private final String JSON_URL = "https://lanuginose-numbers.000webhostapp.com/event/index.php";
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Event> mEvent = new ArrayList<>()  ;
    private RecyclerView recyclerView ;
    private EventAdapter myadapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        recyclerView = findViewById(R.id.recyclerTemp);
        jsonrequest();

        getSupportActionBar().setTitle("Event");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);





    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Event model = new Event() ;
                        model.setId(jsonObject.getString("id"));
                        model.setJudul(jsonObject.getString("judul"));
                        model.setWaktu(jsonObject.getString("waktu"));
                        model.setImg(jsonObject.getString("img_event"));
                        model.setHari(jsonObject.getString("hari"));
                        model.setTanggal(jsonObject.getString("tanggal"));
                        model.setBulan(jsonObject.getString("bulan"));
                        model.setTempat(jsonObject.getString("tempat"));
                        model.setTahun(jsonObject.getString("tahun"));
                        model.setGroup(jsonObject.getString("group"));
                        model.setDeskripsi(jsonObject.getString("deskripsi"));
                        mEvent.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(mEvent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(EventActivity.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Event> mListItem) {


        myadapter2 = new EventAdapter(this,mListItem) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter2);

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
                myadapter2.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
