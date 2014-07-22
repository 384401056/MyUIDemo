package com.blueicehunter.ui06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 自定义的Adapter类。
 *
 * Created by Administrator on 2014/7/22.
 */
public class MyAdapter extends BaseAdapter {

    private Context mContent;
    private ArrayList<UserInfo> mUsers;

    public MyAdapter(Context context, ArrayList<UserInfo> users) {

        this.mContent = context;
        this.mUsers = users;
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mUsers.get(position);
    }

    /**
     * 设置数据源和View之间的关联。
     * @param position Item的位置
     * @param convertView Item的布局或者是View
     * @param parent Item的布局的上层布局
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /* 实例化布局的XML文件转换成其对应的视图对象。*/
        convertView = LayoutInflater.from(mContent).inflate(R.layout.spinner_items01,null);

        ((TextView)convertView.findViewById(R.id.tv01)).setText(mUsers.get(position).getName().toString());
        ((TextView)convertView.findViewById(R.id.tv02)).setText(mUsers.get(position).getAdd().toString());
        ((ImageView)convertView.findViewById(R.id.iv01)).setImageResource(mUsers.get(position).getPic());

        return convertView;
    }
}
