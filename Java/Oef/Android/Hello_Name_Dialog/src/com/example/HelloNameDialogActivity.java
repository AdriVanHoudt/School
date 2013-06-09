package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class HelloNameDialogActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.person_name);
                String name = editText.getText().toString();
                String message = "Hello " + name;

                TextView textView = (TextView) findViewById(R.id.text_view);
                textView.setText(message);

                // Toast toast = Toast.makeText(HelloNameDialogActivity.this, message, Toast.LENGTH_LONG);
                // toast.show();
            }
        });

        Button dialogButton = (Button) findViewById(R.id.dialogButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YesNoDialog();
            }
        });
    }

    private void YesNoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(HelloNameDialogActivity.this);

        builder.setTitle("Exit Application");
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();  // close the dialog
                finish();  // finish activity
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();  //  close the dialog
            }
        });

        builder.create();
        builder.show();
    }
}


