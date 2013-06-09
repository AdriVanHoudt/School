package com.example.LifeCycle;

// http://manisivapuram.blogspot.be/2011/07/activity-life-cycle-example.html

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LifeCycleActivity extends Activity {
    TextView textView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        setText("onCreate");
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStart() {
    //the activity is become visible.
        super.onStart();

        setText("onStart");
        Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();

        setText("onPause");
        Toast.makeText(this, "onPause()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();

        setText("onResume");
        Toast.makeText(this, "onResume()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop() {
    //the activity is no longer visible.
        super.onStop();

        setText("onStop");
        Toast.makeText(this, "onStop()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
    //The activity about to be destroyed.
        super.onDestroy();

        setText("onDestroy");
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_LONG).show();
    }


    private void setText(String string) {
        textView = (TextView) findViewById(R.id.status);
        textView.setText(string);
    }
}

