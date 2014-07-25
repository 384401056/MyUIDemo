package com.blueice.ui09;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ExpandableListActivity {


    private List<HashMap<String,String>> groupData;
    private List<List<HashMap<String,String>>> childData;
    private String[] groupFrom;
    private int[] groupTo;
    private String[] childFrom;
    private int[] childTo;
    private SimpleExpandableListAdapter adapter;

    private ExpandableListView etv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etv = getExpandableListView();



        etv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.i("MyLog",v.toString());
                return false;
            }
        });

        etv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.i("MyLog",v.toString());
                return false;
            }
        });


        this.showExpandableListView();
    }






    private void showExpandableListView(){
        /* 1.建立数据源. */
        groupData = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> groupHashMap1 = new HashMap<String, String>();
        User user1 = new User("KiKi",23);
        groupHashMap1.put("Name",user1.getName());
        groupHashMap1.put("Age",user1.getAge()+"");
        groupData.add(groupHashMap1);

        HashMap<String,String> groupHashMap2 = new HashMap<String, String>();
        User user2 = new User("Vekiya",67);
        groupHashMap2.put("Name",user2.getName());
        groupHashMap2.put("Age",user2.getAge()+"");
        groupData.add(groupHashMap2);

        HashMap<String,String> groupHashMap3 = new HashMap<String, String>();
        User user3 = new User("Nomie",78);
        groupHashMap3.put("Name",user3.getName());
        groupHashMap3.put("Age",user3.getAge()+"");
        groupData.add(groupHashMap3);



        childData = new ArrayList<List<HashMap<String, String>>>();
        List<HashMap<String,String>> childrow= new ArrayList<HashMap<String, String>>();

        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("Id1","edit");
        hashMap.put("Id2","delete");
        hashMap.put("Id3","info");

        childrow.add(hashMap);
        childData.add(childrow);
        childData.add(childrow);
        childData.add(childrow);


        groupFrom = new String[]{
               "Name",
               "Age",
        };

        groupTo = new int[]{
                R.id.group_tv01,
                R.id.group_tv02
        };

        childFrom = new String[]{
                "Id1",
                "Id2",
                "Id3"
        };

        childTo = new int[]{
                R.id.child_tv01,
                R.id.child_tv02,
                R.id.child_tv03,
        };


        /* 2.建立Adapter与数据源、UI的关系。 */
        adapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                R.layout.list_group,
                groupFrom,groupTo,
                childData,
                R.layout.list_child,
                childFrom,childTo);




        /* 将ExpandableListView绑定适配器。 */
        etv.setAdapter(adapter);

    }

}


















