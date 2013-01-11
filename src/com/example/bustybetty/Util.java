package com.example.bustybetty;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class Util {
	
	private static final String HTTP_TAG = "SUCK_MY_HUGE_DICK";
	protected static final String mURL = "https://docs.google.com/spreadsheet/formResponse?hl=en_US&formkey=dEQ0RFhPVU5FNEk0Z3V3aV9DVm1lSkE6MQ";
	
    protected static String submit(String workoutName, String names) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(mURL);

        ArrayList<BasicNameValuePair> results = new ArrayList<BasicNameValuePair>();
        results.add(new BasicNameValuePair("entry.0.single", workoutName));
        results.add(new BasicNameValuePair("entry.1.group", names));

        try {
            post.setEntity(new UrlEncodedFormEntity(results));
        } catch (UnsupportedEncodingException e) {
            // Auto-generated catch block
            Log.e(HTTP_TAG, "An error has occurred", e);
            return "BasicNameValuePairs are fucked";
        }
        try {
            HttpResponse response = client.execute(post); // this is where jellybean fucks up
            String responsestr = EntityUtils.toString(response.getEntity());
        	if(responsestr.contains("Your response has been recorded.")) {
        		return "successfully submitted";
        	} else {
        		return "something's fucked, talk to pmoney";
        	}
            
        } catch (ClientProtocolException e) {
            // Auto-generated catch block
            Log.e(HTTP_TAG, "client protocol exception", e);
            return "client protocol is fucked";
        } catch (IOException e) {
            // Auto-generated catch block
            Log.e(HTTP_TAG, "io exception" + e);
            return "ioexception. do you have signal?";
        }
    }
    
	protected static boolean checkConnection(Context c) {
		ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnected()) {
			return true;
		}
		NetworkInfo mWifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (mWifi != null && mWifi.isConnected()) {
		    return true;
		}
		return false;
	}

}
