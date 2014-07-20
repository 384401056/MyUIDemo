package com.blueicehunter.ui01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

/**
 *
 * 一个最简单的自定义控件定义。
 *
 * Created by Administrator on 2014/7/20.
 */
public class CustomView extends View {

    private Paint paint;

    public CustomView(Context context) {
        super(context);

        /* 设置控件焦点，这样控件内定义的事件才会触发。*/
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /* 定义画笔颜色*/
        paint = new Paint();
        paint.setColor(Color.GREEN);

        /* 画出矩形 */
        canvas.drawRect(10,10,110,110,paint);

        /* 画出文字 */
        paint.setColor(Color.WHITE);
        canvas.drawText("MyButton",20,30,paint);
    }


    /**
     * 如果点击了模拟器键盘上的音量按钮，则触发此事件
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)||(keyCode == KeyEvent.KEYCODE_VOLUME_UP)){
            Log.i("MyLog", "CustomView ******* KEYCODE_VOLUME");
        }

        return super.onKeyUp(keyCode, event);
//        return true;
    }


    /**
     * 如果一直接触屏幕，则触发此事件
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.i("MyLog","CustomView ******* onTouchEvent");
        }


        /* 事件默认返回false,允许父控件再接收触发。如果返回true，则Activity中的相同事件就不会再触发了。 */
        return super.onTouchEvent(event);
//        return true;
    }
}
































