package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MyListViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Zoek de ListView in de resources
       ListView listView = (ListView) findViewById(R.id.mainListView);

       String[] kleurenStrings = {
         "rood", "groen", "blauw", "geel", "orange", "indigo", "violet",
         "cyaan", "magenta", "bruin", "wit", "zwart"
       };
       ArrayList<String> kleuren = new ArrayList<>();
       kleuren.addAll(Arrays.asList(kleurenStrings));

       // Maak de ArrayAdapter
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, R.layout.simplerow, kleuren);

       // Zet de ArrayAdapter als de ListView's adapter
       listView.setAdapter(listAdapter);
    }
}

// Bron: http://windrealm.org/tutorials/android/android-listview.php
