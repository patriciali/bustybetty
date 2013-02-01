package com.example.bustybetty;

import java.util.HashSet;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FacebookAdapter extends BaseAdapter {
    private final Context mContext;
    private final HashSet<Integer> mPositions = new HashSet<Integer>();

    // Keep all Images in array
    public Integer[] mThumbIds = Constants.PICS;

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
        View view = View.inflate(mContext, R.layout.gridview_item, null);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.item_layout);
        layout.setPadding(8, 8, 8, 5);

        ImageView imageview = (ImageView) layout.findViewById(R.id.item_image);
        // janky as hell. don't give a FUK
        int width = mContext.getResources().getDisplayMetrics().widthPixels;
        int colWidth = (width - 20) / 3;
        imageview.setLayoutParams(new LinearLayout.LayoutParams(colWidth-16, colWidth-16));
        imageview.setImageResource(Constants.PICS[position]);
        //imageview.setPadding(8, 8, 8, 8);
        imageview.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        TextView textview = (TextView) layout.findViewById(R.id.item_text);       
        textview.setText(Constants.NAMES[position]);
        textview.setGravity(Gravity.CENTER);

        if(mPositions.contains(position)) {
            view.setBackgroundColor(0xff00ff00);
        } else {
            view.setBackgroundColor(0xffffffff);
        }

        return view;
    }
}