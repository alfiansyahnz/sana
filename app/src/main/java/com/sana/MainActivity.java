package com.sana;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


import com.sana.ui.BottomNavigationViewBehavior;
import com.sana.ui.akun.AkunFragment;
import com.sana.ui.beranda.BerandaFragment;
import com.sana.ui.komunitas.KomunitasFragment;
import com.sana.ui.riwayat.RiwayatFragment;

public class MainActivity extends AppCompatActivity {

    final Fragment fragment1 = new BerandaFragment();
    final Fragment fragment2 = new KomunitasFragment();
    final Fragment fragment3 = new RiwayatFragment();
    final Fragment fragment4 = new AkunFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
//        layoutParams.setBehavior(new BottomNavigationViewBehavior());

        fm.beginTransaction().add(R.id.main_container, fragment4).hide(fragment4).commit();
        fm.beginTransaction().add(R.id.main_container, fragment3).hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2).hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container, fragment1).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;
                    return true;

                case R.id.navigation_komunitas:
                    fm.beginTransaction().hide(active).show(fragment2).commit();
                    active = fragment2;
                    return true;

                case R.id.navigation_riwayat:
                    fm.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3;
                    return true;
                case R.id.navigation_akun:
                    fm.beginTransaction().hide(active).show(fragment4).commit();
                    active = fragment4;
                    return true;
            }
            return false;
        }
    };


}
