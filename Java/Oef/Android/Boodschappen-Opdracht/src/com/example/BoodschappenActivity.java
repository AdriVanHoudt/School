package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


/**
 * Deze klasse moet je aanvullen, vergeet niet eerst je lay-out te maken in /res/layout/main.xml
 */

public class BoodschappenActivity extends Activity {
    private Boodschappen boodschappen = new Boodschappen();  // creatie mock-object
    private CheckBox vlees;
    private CheckBox brood;
    private CheckBox melk;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        vlees = (CheckBox)findViewById(R.id.Vlees);
        brood = (CheckBox)findViewById(R.id.Brood);
        melk = (CheckBox)findViewById(R.id.Melk);

        vlees.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            bereken();
        }
        });
        brood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bereken();
            }
        });
        melk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bereken();
            }
        });
    }

    public void bereken(){
        double total = 0;
        TextView l_total = (TextView)findViewById(R.id.Totaal);
        if (vlees.isChecked()){
           total+=boodschappen.getPrijsEerste();
        }if(brood.isChecked()){
            total+=boodschappen.getPrijsTweede();
        }if(melk.isChecked()){
        total+=boodschappen.getPrijsDerde();
        }
        l_total.setText(String.format("%.2f", total));
    }

}