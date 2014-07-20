package com.blueicehunter.ui02_drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2014/7/20.
 */
public class MyDrawable extends View {

    private BitmapDrawable mBitmapDrawable;
    private Context con;

    /*
    * 使用两个参数的构造函数，才能在布局文件中直接使用自定义控件。
    * 并且要在res下建立一个attr.xml文件。
    */
    public MyDrawable(Context context, AttributeSet attrs) {
        super(context, attrs);

        /* 不设置焦点，控件事件不会触发。 */
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.con = context;
        mBitmapDrawable = new BitmapDrawable();
        mBitmapDrawable = (BitmapDrawable)getResources().getDrawable(R.drawable.mm);
        mBitmapDrawable.setBounds(0,0,350,240);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBitmapDrawable.draw(canvas);

    }


    /**
     * 按下音量键事件。
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            Log.i("MyLog","onKeyUp");
        }

        return super.onKeyUp(keyCode, event);
    }


    /**
     * 点触控件事件。
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if((event.getAction() == MotionEvent.ACTION_DOWN) || (event.getAction() == MotionEvent.ACTION_DOWN)){

            Log.i("MyLog","onTouchEvent");

//            Toast.makeText(con,"你点击了我。",Toast.LENGTH_SHORT);
        }

        return super.onTouchEvent(event);
    }
}























