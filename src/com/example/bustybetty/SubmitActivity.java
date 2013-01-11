package com.example.bustybetty;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SubmitActivity extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        
        final String workoutName = getIntent().getStringExtra("workoutName");
        final String names = getIntent().getStringExtra("names");
        TextView workoutDisplay = (TextView) findViewById(R.id.workouttext);
        TextView namesDisplay = (TextView) findViewById(R.id.namestext);
        workoutDisplay.setText(workoutName);
        namesDisplay.setText(names);
        
        Button submit = (Button) findViewById(R.id.actualsubmitbutton);
        submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(final View v) {
				
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SubmitActivity.this);
		 
					// set title
					alertDialogBuilder.setTitle("submitting...");
		 
					// set dialog message
					alertDialogBuilder
						.setMessage("this should take just a few seconds")
						.setCancelable(false);
//						.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
//							public void onClick(DialogInterface dialog,int id) {
//								// if this button is clicked, close
//								// current activity
//								MainActivity.this.finish();
//							}
//						  })
//						.setNegativeButton("No",new DialogInterface.OnClickListener() {
//							public void onClick(DialogInterface dialog,int id) {
//								// if this button is clicked, just close
//								// the dialog box and do nothing
//								dialog.cancel();
//							}
//						});
		 
						// create alert dialog
						final AlertDialog alertDialog = alertDialogBuilder.create();
		 
						// show it
						alertDialog.show();
			
						class SubmitAsyncTask extends AsyncTask<String, Void, String> {

							@Override
							protected String doInBackground(String...params) {
								String workoutName = params[0];
								String names = params[1];
								String submitResult = Util.submit(workoutName, names);
								//Toast.makeText(MainActivity.this, submitResult, Toast.LENGTH_SHORT).show();
								return submitResult;
							}
							
							@Override
							protected void onPostExecute(String result) {
								alertDialog.cancel();
								
								Context c = v.getContext();
								Intent i = new Intent(c, PreActivity.class);
								c.startActivity(i);
								
						        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
						    }

						}
						
				new SubmitAsyncTask().execute(workoutName, names);
				
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
