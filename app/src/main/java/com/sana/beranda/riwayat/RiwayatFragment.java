package com.sana.beranda.riwayat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.sana.R;

public class RiwayatFragment extends Fragment {

    public RiwayatFragment() {
        // Required empty public constructor
    }
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_riwayat, container, false);

        return root;
    }
}