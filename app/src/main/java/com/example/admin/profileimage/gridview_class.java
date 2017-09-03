package com.example.admin.profileimage;

/**
 * Created by Admin on 9/2/2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class gridview_class extends BaseAdapter {

    Context mContext;
    String[] web;
    int[] Imageid;

    public gridview_class(Context c,String[] web,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }


    @Override
    public int getCount() {
        return web.length;

    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.gridview_row, null);
            TextView textView = (TextView) grid.findViewById(R.id.tv_name1);
            ImageView imageView = (ImageView)grid.findViewById(R.id.img);
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }

}