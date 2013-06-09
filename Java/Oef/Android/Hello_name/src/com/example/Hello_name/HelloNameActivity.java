package com.example.Hello_name;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.R;

public class HelloNameActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.person_name);
                String name = editText.getText().toString();
                String message = "Hello " + name;
                TextView textView = (TextView) findViewById(R.id.text_view);
                textView.setText(message);
                Toast toast = Toast.makeText(HelloNameActivity.this, message, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
