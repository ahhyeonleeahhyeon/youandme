package com.example.s_ahzzng.youandme.Student;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s_ahzzng.youandme.R;

import java.util.ArrayList;

/**
 * Created by inmi on 2017-10-09.
 */

public class homelistAdapter extends BaseAdapter {
    private ArrayList<homelistItem> homelistitemArrayList = new ArrayList<homelistItem>();
    public homelistAdapter(){}
    @Override
    public int getCount() {
        return homelistitemArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return homelistitemArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final Context context = parent.getContext();
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.homelistrow , parent, false);
        }
        ImageView imageView = (ImageView)convertView.findViewById(R.id.homelist_thumb);

        TextView textView = (TextView)convertView.findViewById(R.id.homelist_nick);
        TextView textView2 = (TextView)convertView.findViewById(R.id.homelist_addr);
        TextView textView3 = (TextView)convertView.findViewById(R.id.homelist_host);

        homelistItem item = homelistitemArrayList.get(position);

        int url = item.getThumb();
        imageView.setImageResource(url);
        textView.setText(item.get_nickname());
        textView2.setText(item.getAddress());
        textView3.setText(item.get_hostname());
        return convertView;

    }
    public void addItem(int thumb, String nick, String addr, String host)
    {
        homelistItem item = new homelistItem();
        item.setThumb(thumb);
        item.set_Address(addr);
        item.set_nickname(host);
        homelistitemArrayList.add(item);
    }
}

