package com.blueice.ui07;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


/**
 * 实现ListView的增、删、改、查。
 */
public class MainActivity extends ListActivity {

    private ListView mListView;
    private EditText et01;
    private List<User> userList;
    private MyAdapter adapter;
    private Button btn01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = getListView();
        et01 = (EditText) findViewById(R.id.et01);
        btn01 = (Button)findViewById(R.id.btn01);

        /* EditText 输入文字后按回车键，向ListView中加数据。 */
        et01.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                String etStr = et01.getText().toString();

                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {

                   /* 如果EditView为空则出现提示。否则添加数据 */
                   if (etStr.trim().length()==0){
                       Toast.makeText(MainActivity.this, "输入不能为空!", Toast.LENGTH_SHORT).show();
                       et01.setText(null);
                    } else {
                       userList.add(new User(etStr.trim()));
                       adapter.notifyDataSetChanged();
                       et01.setText(null);
                    }
                }
                return false;
            }
        });


        /* 按钮事件，添加数据 */
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etStr = et01.getText().toString();

               /* 如果EditView为空则出现提示。否则添加数据 */
                if (etStr.trim().length()==0){
                    Toast.makeText(MainActivity.this, "输入不能为空!", Toast.LENGTH_SHORT).show();
                    et01.setText(null);
                } else {
                    userList.add(new User(etStr.trim()));
                    adapter.notifyDataSetChanged();
                    et01.setText(null);
                }
            }
        });


        /* List中的Item长按事件。删除ListView中的数据. */
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                userList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });



        this.showListView();

    }


    private void showListView() {

        userList = new ArrayList<User>();
        adapter = new MyAdapter(this, R.layout.list_item, userList);
        setListAdapter(adapter);
    }

}