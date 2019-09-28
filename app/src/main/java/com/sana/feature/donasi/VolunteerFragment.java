package com.sana.feature.donasi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sana.R;


public class VolunteerFragment extends Fragment {


    public VolunteerFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_volunteer, container, false);

        Button button = view.findViewById(R.id.button_volunteer);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                if (v.getId() == R.id.button_volunteer) {
                    Intent intent = new Intent(getActivity(), FormVolunteerActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

}
