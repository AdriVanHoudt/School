package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MyGridViewActivity extends Activity {
    static final String[] numbers = {
         "1", "2", "3", "4", "5", "6", "7", "8", "9",
         "10", "11", "12", "13", "14", "15", "16", "17"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item, numbers);
        gridView.setAdapter(adapter);
    }
}


// Bron: http://www.mkyong.com/android/android-gridview-example/
