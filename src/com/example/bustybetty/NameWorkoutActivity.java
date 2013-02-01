package com.example.bustybetty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameWorkoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nameworkout);

        Button next = (Button) findViewById(R.id.nameworkout_next);
        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String entered = ((EditText) findViewById(R.id.nameworkout_workout)).getText().toString();

                // entered text must not be empty
                if(entered == null || entered.equals("")) {
                    Toast.makeText(NameWorkoutActivity.this, "please enter a workout name", Toast.LENGTH_SHORT).show();
                    return;
                }

                Context c = v.getContext();
                Intent i = new Intent(c, SelectActivity.class);
                i.putExtra("workoutName", entered);
                c.startActivity(i);
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
