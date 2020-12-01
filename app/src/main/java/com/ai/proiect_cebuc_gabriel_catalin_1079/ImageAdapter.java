package com.ai.proiect_cebuc_gabriel_catalin_1079;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private List<Integer> mThumbIds;
    private Context context;

    public ImageAdapter(List<Integer> mThumbIds, Context context) {
        this.mThumbIds = mThumbIds;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view = (ImageView)convertView;
        if(view == null){
            view = new ImageView(context);
            view.setLayoutParams(new AbsListView.LayoutParams(350, 450));
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        view.setImageResource(mThumbIds.get(position));
        return view;
    }
}
