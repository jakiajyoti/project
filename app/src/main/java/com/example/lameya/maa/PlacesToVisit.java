package com.example.lameya.maa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PlacesToVisit extends AppCompatActivity {

    private EditText editdivision;
    private EditText editseason;
    private EditText editdestination;

    Spinner spdivision,spseason,spdes;
    private Button buttondivision,buttonseason,buttondes;
    String sdiv,ssea,sdes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);

        //Division

        spdivision = (Spinner) findViewById(R.id.spdivision);
        buttondivision = (Button) findViewById(R.id.search_button_division);


        spdivision.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                sdiv = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                //  Toast.makeText(getApplicationContext(),
                //     "Selected Country : " + sarea, Toast.LENGTH_SHORT).show();
                if (sdiv.equals("সিলেট")) {
                    Intent i = new Intent(PlacesToVisit.this, Dhaka.class);
                    // i.putExtra("location", sdiv);
                    startActivity(i);
                } else if (sdiv.equals("চট্টগ্রাম")) {
                    Intent i = new Intent(PlacesToVisit.this, ChittagongList.class);
                    // i.putExtra("location", sdiv);
                    startActivity(i);
                } else if (sdiv.equals("ঢাকা")) {
                    Intent i = new Intent(PlacesToVisit.this, Dhaka.class);
                    // i.putExtra("location", sdiv);
                    startActivity(i);
                }

                buttondivision.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        // editTextName = (EditText) findViewById(R.id.byarea);
                        //  Intent i = new Intent(PlacesToVisit.this, DivisionList.class);
                        // i.putExtra("location", sdiv);
                        //startActivity(i);
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        //Season

        spseason = (Spinner) findViewById(R.id.spseason);
        buttonseason = (Button) findViewById(R.id.search_button_season);


        spseason.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                ssea = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                //  Toast.makeText(getApplicationContext(),
                //     "Selected Country : " + sarea, Toast.LENGTH_SHORT).show();

                buttonseason.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        // editTextName = (EditText) findViewById(R.id.byarea);
                        if(ssea.equals("Rainy"))
                        {
                            Intent i = new Intent(PlacesToVisit.this, RainyList.class);
                            // i.putExtra("location", ssea);
                            startActivity(i);
                        }
                     /*   Intent i = new Intent(PlacesToVisit.this, SeasonList.class);
                        i.putExtra("location", ssea);
                        startActivity(i); */
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        //Destination

        spdes = (Spinner) findViewById(R.id.spdes);
        buttondes = (Button) findViewById(R.id.search_button_des);


        spdes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                sdes = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                //  Toast.makeText(getApplicationContext(),
                //     "Selected Country : " + sarea, Toast.LENGTH_SHORT).show();

                buttondes.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        // editTextName = (EditText) findViewById(R.id.byarea);
                        if(sdes.equals("Museum"))
                        {
                            Intent i = new Intent(PlacesToVisit.this, MuseumList.class);
                            // i.putExtra("location", sdes);
                            startActivity(i);
                        }
                      /*  Intent i = new Intent(PlacesToVisit.this, DestinationList.class);
                        i.putExtra("location", sdes);
                        startActivity(i); */
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });



    }
    }






