package com.google.firebase.codelab.friendlychat;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class Komunitas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komunitas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarkomunitas);
        toolbar.setTitle("Komunitas");
    }
}
