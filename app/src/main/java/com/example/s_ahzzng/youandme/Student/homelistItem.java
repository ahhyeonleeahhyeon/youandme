package com.example.s_ahzzng.youandme.Student;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.s_ahzzng.youandme.R;

import java.util.ArrayList;

/**
 * Created by inmi on 2017-10-09.
 */

public class homelistItem {

    private int _thumbDrawble;
    private String _nickname;
    private String _address;
    private  String _hostname;


    public void set_nickname(String nick){_nickname = nick;};
    public void setThumb(int Thumb){ _thumbDrawble = Thumb;};
    public void set_Address(String address){ _address = address;};
    public void setName(String name){_hostname = name;}

    public int getThumb() { return this._thumbDrawble;};
    public String getAddress(){ return this._address;};
    public String get_hostname(){return this._hostname;};
    public String get_nickname(){return this._nickname;};
}
