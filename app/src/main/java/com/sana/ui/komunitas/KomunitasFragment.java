package com.sana.ui.komunitas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.sana.R;

public class KomunitasFragment extends Fragment {

    private KomunitasViewModel mKomunitasViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mKomunitasViewModel =
                ViewModelProviders.of(this).get(KomunitasViewModel.class);
        View root = inflater.inflate(R.layout.fragment_komunitas, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        mKomunitasViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}