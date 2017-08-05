package com.example.lameya.maa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pageinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageinfo);
    }
    public void dd(View v)
    {Intent i=new Intent(pageinfo.this,placedescription.class);
        startActivity(i);}
    public void ee(View v)
    {Intent i=new Intent(pageinfo.this,howtoreach.class);
        startActivity(i);}
    public void ff(View v)
    {Intent i=new Intent(pageinfo.this,resort.class);
        startActivity(i);}
    public void gg(View v)
    {Intent i=new Intent(pageinfo.this,foodsystem.class);
        startActivity(i);}
}
