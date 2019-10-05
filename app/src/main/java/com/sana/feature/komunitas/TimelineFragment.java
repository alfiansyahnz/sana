package com.sana.feature.komunitas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sana.R;
import com.sana.adapter.TimelineAdapter;
import com.sana.models.Timeline_Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment{


    private final String JSON_URL_TIME = "https://lanuginose-numbers.000webhostapp.com/timeline_post/index.php";
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Timeline_Post> mData = new ArrayList<>()  ;
    private RecyclerView recyclerView ;
    private TimelineAdapter adapter;
    public TimelineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);

        recyclerView = view.findViewById(R.id.recyclerTimeline);

        jsonrequestTimeline();

        String nama_komunitas = getActivity().getIntent().getStringExtra("nama_komunitas");
        String img_komunitas = getActivity().getIntent().getStringExtra("img_komunitas");
        String jml_anggota = getActivity().getIntent().getStringExtra("jml_anggota");


        TextView nama_komunitastxt = view.findViewById(R.id.judul_kom);
        TextView jml_anggotatxt = view.findViewById(R.id.jmlKom);
        ImageView img_komunitasvw = view.findViewById(R.id.imgGambreng);

        nama_komunitastxt.setText(nama_komunitas);
        jml_anggotatxt.setText(jml_anggota);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round).error(R.drawable.bg_round);

        Glide.with(this).load(img_komunitas).apply(requestOptions).into(img_komunitasvw);

        return view;
    }

    private void jsonrequestTimeline() {

        request = new JsonArrayRequest(JSON_URL_TIME, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Timeline_Post model = new Timeline_Post() ;
                        model.setNameUser(jsonObject.getString("nameUser"));
                        model.setWaktuPost(jsonObject.getString("waktuPost"));
                        model.setIsiPost(jsonObject.getString("isiPost"));
                        model.setPostImg(jsonObject.getString("postImg"));
                       /* model.setBagi(jsonObject.getString("bagi"));
                        model.setGabung(jsonObject.getString("gabung"));*/
                        model.setKomentarPost(jsonObject.getString("komentarPost"));
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


        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Timeline_Post> mData) {


        adapter = new TimelineAdapter(TimelineFragment.this,mData);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

    }

}
