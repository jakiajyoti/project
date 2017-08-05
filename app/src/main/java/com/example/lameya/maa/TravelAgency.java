package com.example.lameya.maa;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;



    import android.Manifest;
    import android.app.ProgressDialog;
    import android.content.Context;
    import android.content.Intent;
    import android.content.pm.PackageManager;
    import android.location.Criteria;
    import android.location.Location;
    import android.location.LocationListener;
    import android.location.LocationManager;
    import android.net.Uri;
    import android.os.AsyncTask;
    import android.os.Bundle;
    import android.support.v4.app.ActivityCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageButton;
    import android.widget.TextView;
    import android.widget.Toast;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import android.Manifest;
    import android.app.AlertDialog;
    import android.content.Context;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.content.pm.PackageManager;
    import android.location.Location;
    import android.location.LocationListener;
    import android.location.LocationManager;
    import android.os.Bundle;
    import android.os.IBinder;
    import android.provider.Settings;
    import android.support.v4.app.ActivityCompat;
    import android.util.Log;

    import java.security.Provider;
    import java.util.Timer;


    import android.content.Context;
    import android.location.Criteria;
    import android.location.Location;
    import android.location.LocationListener;
    import android.location.LocationManager;
    import android.os.Bundle;
    import android.app.Activity;
    import android.view.Menu;
    import android.widget.TextView;
    import android.widget.Toast;


    public class TravelAgency extends AppCompatActivity  implements View.OnClickListener, LocationListener{

        private TextView hid; //id
        private TextView name; //name
        private TextView add;//website
        private TextView area;//email
        private TextView contact;//phone


        private Button buttonMap;
        private Button addreview;
        private Button showreview;

        private ImageButton call;
        String contact1;

        private String id,lng1,lat1;
        Double soulang,soulat;

        LocationManager locationmanager;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_travel_agency);

/*
            //location
            locationmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Criteria cri = new Criteria();
            String provider = locationmanager.getBestProvider(cri, false);

            if (provider != null & !provider.equals("")) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Location location = locationmanager.getLastKnownLocation(provider);
                locationmanager.requestLocationUpdates(provider,2000,1,this);
                if(location!=null)
                {
                    onLocationChanged(location);
                }
                else{
                    // Toast.makeText(getApplicationContext(), "location not found", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                // Toast.makeText(getApplicationContext(),"Provider is null",Toast.LENGTH_LONG).show();
            }

            //location finished
*/
            Intent intent = getIntent();

            id = intent.getStringExtra(Config.HOS_ID);

            hid = (TextView) findViewById(R.id.id);
            name = (TextView) findViewById(R.id.name);
            add = (TextView) findViewById(R.id.add);
            area = (TextView) findViewById(R.id.area);
            contact = (TextView) findViewById(R.id.contact);

            buttonMap = (Button) findViewById(R.id.map);
            buttonMap.setOnClickListener(this);
            addreview = (Button) findViewById(R.id.addreview);
            addreview.setOnClickListener(this);
            showreview = (Button) findViewById(R.id.review);
            showreview.setOnClickListener(this);

            call= (ImageButton)findViewById(R.id.call_1);
            call.setOnClickListener(this);


            hid.setText(id);
            getEmployee();
        }

        private void getEmployee() {
            class GetEmployee extends AsyncTask<Void, Void, String> {
                ProgressDialog loading;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(TravelAgency.this, "Fetching...", "Wait...", false, false);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    showEmployee(s);
                }

                @Override
                protected String doInBackground(Void... params) {
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Config.URL_GET_HOS, id);
                    return s;
                }
            }
            GetEmployee ge = new GetEmployee();
            ge.execute();

        }
        //location
        @Override
        public void onLocationChanged(Location location) {
            soulat=location.getLatitude();
            soulang=location.getLongitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        //location
        private void showEmployee(String json) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
                JSONObject c = result.getJSONObject(0);
                //Bundle bundle = getIntent().getExtras();

                String name1 = c.getString(Config.TAG_NAME);
                String add1 = c.getString(Config.TAG_ADD);
                String area1 = c.getString(Config.TAG_AREA);
                contact1 = c.getString(Config.TAG_CONTACT);
                lng1 = c.getString(Config.TAG_LONGTITUDE);
                lat1 = c.getString(Config.TAG_LATITUDE);


                name.setText(name1);
                add.setText(add1);
                area.setText(area1);
                contact.setText(contact1);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }



        @Override
        public void onClick(View v) {
            if (v == call) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", contact1, null)));
            }
            if (v == buttonMap) {

                Double deslong = Double.parseDouble(lng1);
                Double deslat = Double.parseDouble(lat1);

                //Intent i = new Intent(TravelAgency.this, CallAmbulance.class);
               // startActivity(i);
                Uri uri = Uri.parse("http://maps.google.com/maps?daddr=" + Double.toString(deslat) + "," + Double.toString(deslong) + "&saddr=23.7549882,90.3756818"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
            if (v == showreview) {
                //Intent i = new Intent(AtoDhos.this, ShowReview.class);
                //i.putExtra("id", id);
                //startActivity(i);
            }
            if (v == addreview) {
               // Intent i = new Intent(AtoDhos.this, LoginActivity.class);
                //i.putExtra("id", id);
                //startActivity(i);
            }
        }
    }

