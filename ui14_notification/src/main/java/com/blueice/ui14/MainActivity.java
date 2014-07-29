package com.blueice.ui14;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;


public class MainActivity extends Activity {

    private Button btn01,btn02;
    private NotificationManager mNotifiManager;
    private Notification notification;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*1. 通过系统服务建立 NotificationManager */
        mNotifiManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);


        /* 启动普通的Notification */
        btn01 = (Button)findViewById(R.id.button1);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*2. 建立Notification实例。*/
                notification = new Notification(android.R.drawable.ic_notification_clear_all,"Notification tickerText",System.currentTimeMillis());

                pendingIntent = PendingIntent.getActivity(MainActivity.this,0,new Intent(MainActivity.this,Activity01.class),0);
                /* 设置Notification下拉后的显示和点击Notification转到的Intent*/
                notification.setLatestEventInfo(MainActivity.this,"Notification title","Notification ContentText",pendingIntent);

                /*3. 通过NotificationManager显示Notification*/
                mNotifiManager.notify(1,notification);


            }
        });


        /* 启动自宝义的Notification */
        btn02 = (Button)findViewById(R.id.button2);
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 /*2. 建立Notification实例。*/
                notification = new Notification(android.R.drawable.ic_notification_clear_all, "Notification tickerText", System.currentTimeMillis());

                /* 自定义Notification的内容 */
                notification.contentView = new RemoteViews(getPackageName(),R.layout.notification);

                pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, new Intent(MainActivity.this, Activity01.class), 0);
                /*设置点击Notification转到的Intent*/
                notification.contentIntent = pendingIntent;

                /* 自定义后，原来的Title和Message要删除。 */
//                notification.setLatestEventInfo(MainActivity.this, "Notification title", "Notification ContentText", pendingIntent);

                /*3. 通过NotificationManager显示Notification*/
                mNotifiManager.notify(2, notification);
            }
        });

    }

}
































