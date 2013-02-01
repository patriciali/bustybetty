package com.example.bustybetty;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SubmitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        final String workoutName = getIntent().getStringExtra("workoutName");
        final String names = getIntent().getStringExtra("names");
        TextView workoutDisplay = (TextView) findViewById(R.id.submit_workout_entered);
        TextView namesDisplay = (TextView) findViewById(R.id.submit_names_selected);
        workoutDisplay.setText(workoutName);
        namesDisplay.setText(names);

        Button submit = (Button) findViewById(R.id.submit_submit);
        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SubmitActivity.this);
                alertDialogBuilder.setTitle("submitting...");                
                alertDialogBuilder
                .setMessage("this should take just a few seconds")
                .setCancelable(false);

                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                new SubmitAsyncTask(v.getContext(), getApplicationContext(), alertDialog).execute(workoutName, names);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
