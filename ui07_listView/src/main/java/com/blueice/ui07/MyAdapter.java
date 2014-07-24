package com.blueice.ui07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by ServerAdmin on 2014/7/24.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private int resource;
    private List<User> users;


    public MyAdapter(Context context,int resource,List<User> users ){
        this.context = context;
        this.resource = resource;
        this.users = users;
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /* 实例化布局的XML文件转换成其对应的视图对象。*/
        convertView = LayoutInflater.from(this.context).inflate(this.resource,null);
        ((TextView)convertView.findViewById(R.id.lsit_tv01)).setText(users.get(position).getName().toString());

        return convertView;
    }
}

















