package com.example.lameya.maa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dhaka extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka);
    }
    public void thi(View v)
    {Intent i=new Intent(Dhaka.this,pageinfo.class);
        startActivity(i);}


}
