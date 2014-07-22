package com.blueicehunter.ui06;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * 用自定的Adapter来绑定数据到 Spinner 控件中去。
 *
 * Created by Administrator on 2014/7/22.
 */
public class MainActivity extends Activity {

    private ArrayList<UserInfo> mUsers;
    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner)findViewById(R.id.spinner01);



        /* 1.生成数据源。 */
        mUsers = new ArrayList<UserInfo>();
        mUsers.add(new UserInfo("张龙","开封府",R.drawable.icon01));
        mUsers.add(new UserInfo("赵虎","开封府",R.drawable.icon02));
        mUsers.add(new UserInfo("王朝","开封府",R.drawable.icon03));
        mUsers.add(new UserInfo("马汉","开封府",R.drawable.icon04));

        /* 2.建立Adapter并传入数据源 */
        MyAdapter adapter = new MyAdapter(MainActivity.this,mUsers);

        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String str = ((TextView)view.findViewById(R.id.tv01)).getText().toString();
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}



























