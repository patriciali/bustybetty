package com.example.bustybetty;

import java.util.HashSet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class FacebookAdapter extends BaseAdapter {
    private final Context mContext;
    private final HashSet<Integer> mPositions = new HashSet<Integer>();

    // Keep all Images in array
    public Integer[] mThumbIds = { R.drawable.abby, R.drawable.alex, R.drawable.alina, R.drawable.becky,
            R.drawable.cami, R.drawable.carolyn, R.drawable.charlotte, R.drawable.evie, R.drawable.fpack,
            R.drawable.heather, R.drawable.kathleen, R.drawable.kelly, R.drawable.kristen, R.drawable.lily,
            R.drawable.lisa, R.drawable.liz, R.drawable.maggie, R.drawable.meaghan, R.drawable.michelle,
            R.drawable.monica, R.drawable.neerja, R.drawable.patricia, R.drawable.sluts };

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