package com.sana.feature.donasi;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.sana.R;
import com.sana.adapter.TabAdapter;

public class DetailDonasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_donasi);

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new DonasiFragment(), "Donasi");
        adapter.addFragment(new VolunteerFragment(), "Volunteer");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
