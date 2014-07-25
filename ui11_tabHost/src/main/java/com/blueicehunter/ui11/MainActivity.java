package com.blueicehunter.ui11;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;



public class MainActivity extends TabActivity {

    private TabHost.TabSpec spec1,spec2;
    private TabHost tabHost;
    private View.OnTouchListener touchListener;

    /* 手势检测对象 */
    private GestureDetector gestureDetector;

    /** 记录当前分页ID */
    private int currentView = 0;
    private static int maxTabIndex = 2;

    // *********************************
    private static final int SWIPE_MIN_DISTANCE = 120; /* 滑动的最小距离 */
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200; /* 移动速度 */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initTabHost();

        /*
        * 通过系统提供的MotionEvent来监测各种手势和（触摸）事件。当一个指定的手势事件发生时，GestureDetector.OnGestureListener回调函数将通告用户。
        * 这个类仅仅处理由触摸引发的MotionEvent（不能处理由轨迹球引发的事件）。要使用这个类需执行以下操作：
        * 1.为你的View建立一个GestureDetector实例。
        * 2。在View的onTouchEvent(MotionEvent)方法里确保调用（GestureDetector的）onTouchEvent(MotionEvent)方法。
        * 当相关事件发生时，定义在回调函数里的方法将被执行。
        */
        gestureDetector = new GestureDetector(new MyGestureDetector());
        touchListener = new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        };
    }


    /**
     * 分析指定的动作事件，如何满足条件，就触发在GestureDetector.OnGestureListener中提供的回调函数
     * @param ev 当前的触摸事件（如:MotionEvent_DOWN, MotionEvent_UP）
     * @return 如果GestureDetector.OnGestureListener消耗了这个事件，则返回true，否则返回false

     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (gestureDetector.onTouchEvent(ev)) {
            ev.setAction(MotionEvent.ACTION_CANCEL);
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 创建Tab
     */
    private void initTabHost(){
        tabHost = getTabHost();
        spec1 = tabHost.newTabSpec("Activity1")
                /* 新版本的SDK不支持同时显示文字和图片。所以文字为空时，图片才有效 */
                .setIndicator("", getResources().getDrawable(R.drawable.realbtn_selector))
                .setContent(new Intent(MainActivity.this, Activity1.class));
        tabHost.addTab(spec1);

        spec2 = tabHost.newTabSpec("Activity2")
                .setIndicator("",getResources().getDrawable(R.drawable.alarmbtn_selector))
                .setContent(new Intent(MainActivity.this,Activity2.class));
        tabHost.addTab(spec2);

//        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
//            @Override
//            public void onTabChanged(String s) {
//                Log.i("MyLog", s);
//            }
//        });

        tabHost.setCurrentTab(0);
    }


    /* SimpleOnGestureListener:当只需要监听部分手势时，用于扩展的便捷类 */
    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {

        /**
         * @param e1 第1个ACTION_DOWN MotionEvent 并且只有一个
         * @param e2 最后一个ACTION_MOVE MotionEvent
         * @param velocityX X轴上的移动速度，像素/秒
         * @param velocityY Y轴上的移动速度，像素/秒
         * @return
         */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,float velocityY) {
            try {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                    return false;

                /* 如果第接触点和最后的接触点相差120,并且速度超过200，说明手指是向右移动*/
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    if (currentView == maxTabIndex) {
                        currentView = 0;
                    } else {
                        currentView++;
                    }
                    tabHost.setCurrentTab(currentView);

                  /* 如果最后的接触点和第接触点相差120,并且速度超过200，说明手指是向左移动*/
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    if (currentView == 0) {
                        currentView = maxTabIndex;
                    } else {
                        currentView--;
                    }
                    tabHost.setCurrentTab(currentView);
                }
            } catch (Exception e) {
            }
            return false;
        }
    }
}
