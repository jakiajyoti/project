package com.example.lameya.maa;


        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
        import java.util.ArrayList;
        import java.util.HashMap;

public class TravelAgencyList extends AppCompatActivity implements ListView.OnItemClickListener{


    private ListView listView;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_agency_list);
        listView = (ListView) findViewById(R.id.all_a_d_listView);
        listView.setOnItemClickListener(this);
        getJSON();
    }


    private void showEmployee(){
        //  JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            JSONObject jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);


            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Config.TAG_ID);
                String name = jo.getString(Config.TAG_NAME);
                HashMap<String,String> employees = new HashMap<>();
                employees.put(Config.TAG_ID,id);
                employees.put(Config.TAG_NAME,name);
                // employees.put(Config.TAG_ACONTACT,Contact);
                list.add(employees);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListAdapter adapter = new SimpleAdapter(
                TravelAgencyList.this, list, R.layout.hotel_list_item,
                new String[]{Config.TAG_ID,Config.TAG_NAME},
                new int[]{R.id.id,R.id.name});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TravelAgencyList.this,"Fetching Data","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                loading.dismiss();

                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Config.URL_GET_ALL_A_HOS);

                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(TravelAgencyList.this, TravelAgency.class);

        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empId = map.get(Config.TAG_ID).toString();
        intent.putExtra(Config.HOS_ID, empId);

        startActivity(intent);
    }
}


