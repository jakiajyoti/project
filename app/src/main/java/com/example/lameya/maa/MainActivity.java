package com.example.lameya.maa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Animation fa, fo;
    ViewFlipper vf;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        vf = (ViewFlipper) this.findViewById(R.id.bk);
        fa = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fo = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        vf.setInAnimation(fa);
        vf.setInAnimation(fo);
        vf.setAutoStart(true);
        vf.setFlipInterval(3500);
        vf.startFlipping();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void dis(View v)
    {
        Intent i=new Intent(MainActivity.this,OfferOne.class);
        startActivity(i);
    }


    public void vr(View v)
    {
        Intent i=new Intent(MainActivity.this,PlacesToVisit.class);
        startActivity(i);
        }

    public void ta(View v)
    {Intent i=new Intent(MainActivity.this,ViewAllEmployee.class);
        startActivity(i);}



    public void voi(View v)
    {Intent i=new Intent(MainActivity.this,PictureCommunication.class);
        startActivity(i);}



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        // FragmentManager fm = getFragmentManager();


         if (id == R.id.nav_d1) {
            // fm.beginTransaction().replace(R.id.content_frame, new help()).commit();
            Intent ine= new Intent(MainActivity.this,PlacesToVisit.class);
           startActivity(ine);

        }
        if (id == R.id.nav_d2) {
            // fm.beginTransaction().replace(R.id.content_frame, new help()).commit();
            Intent ine= new Intent(MainActivity.this,PlacesToVisit.class);
            startActivity(ine);

        }
        if (id == R.id.nav_d3) {
            // fm.beginTransaction().replace(R.id.content_frame, new help()).commit();
            Intent ine= new Intent(MainActivity.this,PlacesToVisit.class);
             startActivity(ine);

        }
        if (id == R.id.nav_d4) {
            // fm.beginTransaction().replace(R.id.content_frame, new help()).commit();
            Intent ine= new Intent(MainActivity.this,PlacesToVisit.class);
             startActivity(ine);

        }

        else if (id == R.id.nav_t11) {
            // fm.beginTransaction().replace(R.id.content_frame, new help()).commit();




            String map = "http://maps.google.co.in/maps?q=SUST,3114,University Ave ,Sylhet";
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Only if initiating from a Broadcast Receiver
            String mapsPackageName = "com.google.android.apps.maps";
            i.setClassName(mapsPackageName, "com.google.android.maps.MapsActivity");
            i.setPackage(mapsPackageName);
            startActivity(i);

        }
        if (id == R.id.nav_t12) {
            // Handle the camera action
            // fm.beginTransaction().replace(R.id.content_frame, new logout()).commit();
            Intent ine= new Intent(MainActivity.this,ViewAllEmployee.class);
            startActivity(ine);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
