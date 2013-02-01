package com.example.bustybetty;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

class SubmitAsyncTask extends AsyncTask<String, Void, String> {

    Context mContext;
    Context mAppContext;
    AlertDialog mAlertDialog;

    public SubmitAsyncTask(Context c, Context appContext, AlertDialog d) {
        mContext = c;
        mAppContext = appContext;
        mAlertDialog = d;
    }

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
        mAlertDialog.cancel();

        Intent i = new Intent(mContext, NameWorkoutActivity.class);
        mContext.startActivity(i);

        Toast.makeText(mAppContext, result, Toast.LENGTH_LONG).show();
    }

}