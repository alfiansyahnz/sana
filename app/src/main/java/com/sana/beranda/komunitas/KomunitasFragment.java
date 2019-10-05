package com.sana.beranda.komunitas;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.sana.R;
import com.sana.adapter.TabAdapter;
import com.sana.feature.komunitas.ChatFragment;
import com.sana.feature.komunitas.TimelineFragment;

public class KomunitasFragment extends Fragment {

    public KomunitasFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_komunitas, container, false);
        ViewPager viewPager = root.findViewById(R.id.viewPager);
        TabLayout tabLayout = root.findViewById(R.id.tabLayoutkom);
        TabAdapter adapter = new TabAdapter(getActivity().getSupportFragmentManager());
//        adapter.addFragment(new TimelineFragment(), "Timeline");
//        adapter.addFragment(new ChatFragment(), "Chat");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }
}