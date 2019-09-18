package com.sana;

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
import com.sana.adapter.ChallengeAdapter;
import com.sana.models.Challenge;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChallengeActivity extends AppCompatActivity {

    //private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json" ;
    private final String JSON_URL = "https://lanuginose-numbers.000webhostapp.com/challenge/index.php";
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Challenge> mListItem ;
    private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        mListItem = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerTemp);

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
                        Challenge model = new Challenge() ;
                        model.setId(jsonObject.getString("id"));
                        model.setJudul(jsonObject.getString("judul"));
                        model.setDeskripsi(jsonObject.getString("deskripsi"));
                        model.setSuka(jsonObject.getInt("suka"));
                        model.setBagi(jsonObject.getInt("bagi"));
                        model.setGabung(jsonObject.getInt("gabung"));
                        model.setImg(jsonObject.getString("img"));
                        mListItem.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(mListItem);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(ChallengeActivity.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Challenge> mListItem) {


        ChallengeAdapter myadapter = new ChallengeAdapter(this,mListItem) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }

    private void runLayoutAnimation(RecyclerView recyclerView){
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_slide_right);

        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();


    }
}
