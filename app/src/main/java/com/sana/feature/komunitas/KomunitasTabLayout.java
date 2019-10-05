//package com.sana.feature.komunitas;
//
//import android.graphics.Color;
//import android.support.design.widget.TabLayout;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//import com.sana.R;
//import com.sana.adapter.TabAdapter;
//
//
//public class KomunitasTabLayout extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_komunitas_tab_layout);
//
//        ViewPager viewPager = findViewById(R.id.viewPager);
//        TabLayout tabLayout = findViewById(R.id.tabLayoutkom);
//        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
//        adapter.addFragment(new TimelineFragment(), "Timeline");
//        adapter.addFragment(new ChatFragment(), "Chat");
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);
//
//    }
//}
