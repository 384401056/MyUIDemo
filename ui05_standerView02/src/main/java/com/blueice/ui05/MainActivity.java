package com.blueice.ui05;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;


/**
 * 一些常用控件的显示设置和基本事件。
 */
public class MainActivity extends Activity {

    private Button btn;
    private ToggleButton togBtn;
    private CheckBox cb;
    private RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了Button",Toast.LENGTH_SHORT).show();
            }
        });


        togBtn = (ToggleButton)findViewById(R.id.tbtn01);
        togBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    /* 也可以代码中来改变图片 */
//                    buttonView.setBackgroundResource(R.drawable.on);
                    Toast.makeText(MainActivity.this,"打开了",Toast.LENGTH_SHORT).show();
                }
                else{
//                    buttonView.setBackgroundResource(R.drawable.off);
                    Toast.makeText(MainActivity.this,"关闭了",Toast.LENGTH_SHORT).show();
                }
            }
        });


        cb = (CheckBox)findViewById(R.id.checkBox);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    /* 也可以代码中来改变图片 */
//                    buttonView.setButtonDrawable(R.drawable.select_0);
                }
                else{
//                    buttonView.setButtonDrawable(R.drawable.select_1);
                }
            }
        });

    }
}

















