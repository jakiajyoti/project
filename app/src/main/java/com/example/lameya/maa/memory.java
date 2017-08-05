package com.example.lameya.maa;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

public class memory extends AppCompatActivity implements View.OnClickListener {
   /* private Calendar cal;
    private int day;
    private int month;
    private int year;*/



    private EditText editTextName;
    private EditText editTextDesg;
    private EditText editTextSal;

    private EditText editTextNam;

    private Button buttonAdd;
    private Button buttonView;
    private Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        //Initializing views
        editTextName = (EditText) findViewById(R.id.editTextName);


        editTextNam = (EditText) findViewById(R.id.editTextNam);

        editTextDesg = (EditText) findViewById(R.id.editTextDesg);
        editTextSal = (EditText) findViewById(R.id.editTextSalary);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);


        dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"হোটেল", "ট্রাভেল এজেন্সি", "অন্যান্য"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);}



       /* cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH)+1;
        year = cal.get(Calendar.YEAR);
        //month=month+1;

        editTextDesg.setText(day+"/"+month+"/"+year);



        editTextDesg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DateDialog();

            }
        });
    }*/
   /* public void DateDialog(){

        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth)
            {

                editTextDesg.setText(dayOfMonth+"/"+monthOfYear+"/"+year);

            }};

        DatePickerDialog dpDialog=new DatePickerDialog(this, listener, year, month, day);
        dpDialog.show();

    }*/


    //Adding an employee
    private void addEmployee(){

        final String name = dropdown.getSelectedItem().toString();

        final String nam = editTextNam.getText().toString().trim();

        final String desg = editTextDesg.getText().toString().trim();
        final String sal = editTextSal.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(memory.this,"অপেক্ষা করুন...","যুক্ত হচ্ছে...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(memory.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME,name);

                params.put(Config.KEY_EMP_NAM,nam);

                params.put(Config.KEY_EMP_DESG,desg);
                params.put(Config.KEY_EMP_SAL,sal);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addEmployee();
        }

        if(v == buttonView){
            Intent i=new Intent(memory.this,ViewEmployee.class);
            startActivity(i);
            // startActivity(new Intent(this,ViewAllEmployee.class));
        }

    }
    private void logout(){
        //Creating an alert dialog to confirm logout
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("আপনি কি লগ আউট করতে চান ?");
        alertDialogBuilder.setPositiveButton("হ্যাঁ",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        //Getting out sharedpreferences
                        SharedPreferences preferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                        //Getting editor
                        SharedPreferences.Editor editor = preferences.edit();

                        //Puting the value false for loggedin
                        editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, false);

                        //Putting blank value to email
                        editor.putString(Config.EMAIL_SHARED_PREF, "");

                        //Saving the sharedpreferences
                        editor.commit();

                        //Starting login activity
                        Intent intent = new Intent(memory.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

        alertDialogBuilder.setNegativeButton("না",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        //Showing the alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Adding our menu to toolbar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuLogout) {
            //calling logout method when the logout button is clicked
            logout();
        }
        return super.onOptionsItemSelected(item);
    }
}
