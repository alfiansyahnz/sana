package com.sana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.sana.R;

public class SplashActivity extends AppCompatActivity {

    LinearLayout img_logo, img_pohon;
    Animation mytransition, downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        img_logo = findViewById(R.id.img_logo);
        img_pohon = findViewById(R.id.img_pohon);
        mytransition = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        img_logo.setAnimation(mytransition);
        img_pohon.setAnimation(downtoup);
        final Intent i = new Intent(this,OnBoardingActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                finally {
                    startActivity(i);
                    finish();
                }
            }
        };

                timer.start();
    }
}
