package com.example.lameya.maa;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
public class PictureCommunication extends AppCompatActivity {

    MediaPlayer mp        = null;
    String where="where";
    String how="how";
    String fare="fare";
    String price="price";
    String distance="distance";
    String restuarant="restuarant";
    String texi="texi";
    String bus="bus";


    String string1="x";
    String string2="x";
    String string3="x";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_communication);


        final ImageButton buttonwhere=(ImageButton)findViewById(R.id.where);
        buttonwhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.text1)).setText("Where is");
                string1=where;


                managerOfSound(where);
            } // END onClick()
        }); // END Button

        final ImageButton buttonhow=(ImageButton)findViewById(R.id.how);
        buttonhow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.text1)).setText("How much");
                string1=how;
                managerOfSound(how);
            } // END onClick()
        }); // END Button

        final ImageButton buttonfare=(ImageButton)findViewById(R.id.fare);
        buttonfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.text2)).setText("fare of");
                string2=fare;
                managerOfSound(fare);
            } // END onClick()
        }); // END Button
        final ImageButton buttondis=(ImageButton)findViewById(R.id.distance);
        buttondis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.text2)).setText("distance of");
                string2=distance;
                managerOfSound(distance);
            } // END onClick()
        }); // END Button
        final ImageButton buttonprice=(ImageButton)findViewById(R.id.price);
        buttonprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.text2)).setText("price of");
                string2=price;
                managerOfSound(price);
            } // END onClick()
        }); // END Button
        final ImageButton buttonbus=(ImageButton)findViewById(R.id.busstation);
        buttonbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.text3)).setText("bus station");
                string3=bus;
                managerOfSound(bus);
            } // END onClick()
        }); // END Button
        final ImageButton buttontexi=(ImageButton)findViewById(R.id.texi);
        buttontexi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.text3)).setText("taxi");
                string3=texi;
                managerOfSound(texi);
            } // END onClick()
        }); // END Button
        final ImageButton buttonres=(ImageButton)findViewById(R.id.restuarants);
        buttonres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.text3)).setText("restuarants");
                string1=restuarant;
                managerOfSound(restuarant);
            } // END onClick()
        }); // END Button

        final Button play=(Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(string1!="x") {
                    Log.d("string1", string1);
                    managerOfSound(string1);

                }
                if(string2!="x") {
                    Log.d("string2", string2);

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 1000ms
                            managerOfSound(string2);
                        }
                    }, 1000);

                    //  managerOfSound(string2);


                }
                if(string3!="x") {
                    Log.d("string3", string3);

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 2000ms
                            managerOfSound(string3);
                        }
                    }, 2000);

                    //  managerOfSound(string2);


                }


            }

        });
    } // oncreate() end

    /**
     * Manager of Sounds
     */
    protected void managerOfSound(String theText) {
        if (mp != null) {
            mp.reset();
            mp.release();
        }
        Log.d("the text", theText);
        if (theText == where)
            mp = MediaPlayer.create(this, R.raw.how);
        else if (theText == how)
            mp = MediaPlayer.create(this, R.raw.how);
        else if (theText == fare)
            mp = MediaPlayer.create(this, R.raw.fair);
        else if (theText == distance)
            mp = MediaPlayer.create(this, R.raw.dis);
        else if (theText == price)
            mp = MediaPlayer.create(this, R.raw.price);
        else if (theText == bus)
            mp = MediaPlayer.create(this, R.raw.busstation);
        else if (theText == texi)
            mp = MediaPlayer.create(this, R.raw.texi);
        else if (theText == restuarant)
            mp = MediaPlayer.create(this, R.raw.res);


        mp.start();
    }

}



