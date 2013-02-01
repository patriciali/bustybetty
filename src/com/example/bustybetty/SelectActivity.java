package com.example.bustybetty;

import java.util.TreeSet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
//import android.widget.EditText;

public class SelectActivity extends Activity {

    //	private static Toast sAddress;
    public TreeSet<String> mPresent = new TreeSet<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        final GridView gridview = (GridView) findViewById(R.id.select_gridview);
        gridview.setAdapter(new FacebookAdapter(this));
        gridview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String name = Constants.NAMES[position];

                //        		if(sAddress == null) {
                //        			sAddress = Toast.makeText(MainActivity.this, "" + name, Toast.LENGTH_SHORT);
                //        		} else {
                //        			sAddress.cancel();
                //        			sAddress.setText("" + name);
                //        		}
                //        		sAddress.show();

                ((FacebookAdapter) gridview.getAdapter()).toggle(position);
                if(mPresent.contains(name)) {
                    mPresent.remove(name);
                    v.setBackgroundColor(0xffffffff);
                } else {
                    mPresent.add(name);
                    v.setBackgroundColor(0xff00ff00);
                }
            }
        });

        Button submit = (Button) findViewById(R.id.select_next);
        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "";

                // there must be at least one person selected
                if(mPresent.isEmpty()) {
                    error = "please select some people";
                }
                // need network connection
                //				else if(Util.checkConnection(v.getContext())) {
                //					error = "no network connection";
                //				}

                if (!error.equals("")) {
                    //					if (sAddress == null) {
                    //						sAddress = Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT);
                    //					} else {
                    //						sAddress.cancel();
                    //						sAddress.setText(error);
                    //					}
                    //					sAddress.show();
                    //					return;
                    Toast.makeText(SelectActivity.this, error, Toast.LENGTH_SHORT).show();
                    return;
                }

                // send to confirm page
                String workoutName = getIntent().getStringExtra("workoutName");
                String namestr = mPresent.toString();
                String actual_namestr = namestr.substring(1, namestr.length()-1);

                Context c = v.getContext();
                Intent i = new Intent(c, SubmitActivity.class);
                i.putExtra("workoutName", workoutName);
                i.putExtra("names", actual_namestr);
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