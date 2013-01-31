package com.example.bustybetty;

import java.util.HashSet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class FacebookAdapter extends BaseAdapter {
    private Context mContext;
    private HashSet<Integer> mPositions = new HashSet<Integer>();
 
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.pic_1, R.drawable.pic_2,
            R.drawable.pic_3, R.drawable.pic_4,
            R.drawable.pic_5, R.drawable.pic_6,
            R.drawable.pic_7, R.drawable.pic_8,
            R.drawable.pic_9, R.drawable.pic_10,
            R.drawable.pic_11, R.drawable.pic_12,
            R.drawable.pic_13, R.drawable.pic_14,
            R.drawable.pic_15, R.drawable.pic_16,
            R.drawable.pic_17, R.drawable.pic_18,
            R.drawable.pic_19, R.drawable.pic_20,
            R.drawable.pic_21, R.drawable.pic_22,
            R.drawable.pic_23
    };
 
    // Constructor
    public FacebookAdapter(Context c){
        mContext = c;
    }
    
    public void toggle(int position) {
    	if(mPositions.contains(position)) {
    		mPositions.remove(position);
    	} else {
    		mPositions.add(position);
    	}
    }
 
    @Override
    public int getCount() {
        return mThumbIds.length;
    }
 
    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        
        // janky as hell. don't give a FUK
        int width = mContext.getResources().getDisplayMetrics().widthPixels;
        //int height = mContext.getResources().getDisplayMetrics().heightPixels;
        int colWidth = (width-20)/3;
        imageView.setLayoutParams(new GridView.LayoutParams(colWidth, colWidth));
        
        imageView.setImageResource(mThumbIds[position]);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        
        if(mPositions.contains(position)) {
            imageView.setBackgroundColor(0xff00ff00);
        } else {
        	imageView.setBackgroundColor(0xffffffff);
        }
        return imageView;
    }
}