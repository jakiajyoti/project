package com.example.lameya.maa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Main2Activity extends Activity {

    private static int TIME_OUT = 2000; //Time to launch the another activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // final View myLayout = findViewById(R.id.startscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }

}