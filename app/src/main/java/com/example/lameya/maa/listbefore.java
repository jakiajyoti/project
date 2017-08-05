package com.example.lameya.maa;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listbefore extends ListActivity {
    String classes[] = {"1-4 week", "4-8 week", "8-13 week",
            "Download A File", "Upload A File", "Select Pdf files", "Memory Game",
            "Dzidza Maths", "Write Exam","ers","dfsr","rgehtr","dgreg","thtr","tre"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(listbefore.this,
                android.R.layout.simple_list_item_1, classes));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);


    }
}