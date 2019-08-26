package com.sana;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class OnBoardingActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mNextButton;
    private Button mBackButton;
    private Button mMulaiButton;

    private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);



        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mNextButton = (Button) findViewById(R.id.btn_next);
        mBackButton = (Button) findViewById(R.id.btn_prev);
        mMulaiButton = (Button) findViewById(R.id.btn_mulai);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        if (restorePrevData()){

            Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivity);
            finish();
        }



        //OnCLickListeneir
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);

            }
        });
    }

    private boolean restorePrevData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref", MODE_PRIVATE);
        Boolean isIntroActivityBefore = pref.getBoolean("IniOnboarding",false);
        return isIntroActivityBefore;

    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTrans));

            mDotLayout.addView(mDots[i]);

        }

        if(mDots.length > 0){


            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            mCurrentPage = i;

            if(i == 0){

                mMulaiButton.setEnabled(false);
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(false);
                mBackButton.setVisibility(View.INVISIBLE);

                mNextButton.setText("Berikutnya");
                mBackButton.setText("");
                mMulaiButton.setText("");
            }

            else if(i == mDots.length - 1){

                mNextButton.setEnabled(false);
                mBackButton.setEnabled(true);
                mMulaiButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);
                mMulaiButton.setVisibility(View.VISIBLE);

                mMulaiButton.setText("Mulai");
                mNextButton.setText("");
                mBackButton.setText("Kembali");

                mMulaiButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(mainActivity);

                        savePrefsData();
                    }
                });
            }

            else {

                mNextButton.setEnabled(true);
                mMulaiButton.setEnabled(false);
                mBackButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);

                mMulaiButton.setText("");
                mNextButton.setText("Berikutnya");
                mBackButton.setText("Kembali");

            }

        }



        private void savePrefsData(){

            SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("IniOnboarding",true);
            editor.commit();
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }


    };


}
