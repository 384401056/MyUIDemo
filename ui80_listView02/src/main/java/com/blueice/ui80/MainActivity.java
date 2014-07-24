package com.blueice.ui80;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {

    private List<User> data;
    private MyAdapter adapter;
    private ListView mListView;
    private TextView tv01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = getListView();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Boolean swich = data.get(position).getIsOpen();
                data.get(position).setIsOpen(!swich);
                adapter.notifyDataSetChanged();
            }
        });


        ShowListView();

    }

    private void ShowListView(){
        data = new ArrayList<User>();
        data.add(new User("aaaaaaaa"));
        data.add(new User("bbbbbbbb"));
        data.add(new User("dddddddd"));
        data.add(new User("wwwwwwww"));
        data.add(new User("eeeeeeee"));

        adapter = new MyAdapter(this,R.layout.list_item,data);

        setListAdapter(adapter);

    }


}
