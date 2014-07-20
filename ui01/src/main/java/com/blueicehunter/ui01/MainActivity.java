package com.blueicehunter.ui01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * 用来放置自定义的控件。
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        * 定义CustomView控件的事件
        * CustomView是个全屏大小的，所有点击窗体的空白地方也会触发事件。
        */
        CustomView customView = new CustomView(this);
/*
        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点了自定义控件 。",Toast.LENGTH_SHORT).show();
            }
        });
*/

        setContentView(customView);

    }

    /*
     * 我们在Activity中也实现和CustomView中相同的事件，看看他们的执行顺序。
     * 此时要把CustomView的OnClickListener关掉。否则onTouchEvent事件年不会执行。
     */

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)||(keyCode == KeyEvent.KEYCODE_VOLUME_UP)){
            Log.i("MyLog", "MainActivity ******* KEYCODE_VOLUME");
        }

        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.i("MyLog","MainActivity ******* onTouchEvent ACTION_DOWN");
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){

            /* 如果整个onTouchEvent事件发生完成的时间减去按下时的时间大于3秒，则定义为:LongTimeDown */
            if(event.getEventTime()-event.getDownTime()>3000) {

                Log.i("MyLog", "MainActivity ******* onTouchEvent LongTimeDown.");
            }
        }

        return super.onTouchEvent(event);
    }
}
























