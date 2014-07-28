package com.blueice.ui12;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class MainActivity extends ListActivity {

    private String[] data;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        data = new String[]{"gaoyanbin","Yianliiwe","yuiellsnd","terrelsd"};
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        setListAdapter(arrayAdapter);
        registerForContextMenu(getListView());

    }




    /**
     * 上下文菜单
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.main, menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        /* 获得点击了的context菜单信息。 */
        Log.i("MyLog","getGroupId:"+item.getItemId());
        Log.i("MyLog","getTitle:"+item.getTitle());


        /* 获得ListView的信息。position为ListView中的位置。 */
        AdapterView.AdapterContextMenuInfo adapterInfor = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        Log.i("MyLog","position:"+adapterInfor.position);
        Log.i("MyLog",""+adapterInfor.id);


        return super.onContextItemSelected(item);
    }

    /**
     * Option菜单。
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,"ItemId:"+item.getItemId(),Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
