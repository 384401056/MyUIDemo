package com.blueice.ui05;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


/**
 * 一些常用控件的显示设置和基本事件。
 */
public class MainActivity extends Activity {

    private Button btn;
    private ToggleButton togBtn;
    private CheckBox cb;
    private ProgressBar prg01;
    private SeekBar sbar01;
    private RatingBar rtb;
    private EditText et01;
    private AutoCompleteTextView autoCompleteTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prg01 = (ProgressBar)findViewById(R.id.pg01);
        sbar01 = (SeekBar)findViewById(R.id.sb01);
        rtb = (RatingBar)findViewById(R.id.ratingBar);
        et01 = (EditText)findViewById(R.id.et01);
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoComptv);


        btn = (Button)findViewById(R.id.btn01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了Button",Toast.LENGTH_SHORT).show();

                prg01.setProgress(prg01.getProgress()+3);
                if(prg01.getProgress()>=prg01.getMax()){
                    prg01.setProgress(0);
                }

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


        /* 当thumd拖动时的监听事件 */
        sbar01.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            /**
             * 当ProgressBar在拖动过程中执行的方法。
             * @param seekBar
             * @param progress
             * @param fromUser
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("MyLog", "正在拖动.........");
            }

            /**
             * 开始点击拖动按钮时执行的方法
             * @param seekBar
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("MyLog", "点击了按钮，要开始拖啦......");
            }

            /**
             * 结束拖动时执行的方法。
             * @param seekBar
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("MyLog", "放开按钮，不拖了......");
            }
        });


        /**
         * RatingBar组件的评级改变事件。
         */
        rtb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Toast.makeText(MainActivity.this,"星级："+ rating,Toast.LENGTH_SHORT).show();

            }
        });


        /**
         * EditText 的编辑行为事件监听。
         * 其中参数，当按下回车时ActionId返回0.
         */
        et01.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                Log.i("MyLog","AtionId:"+actionId);

                if(actionId==0){
                    Toast.makeText(MainActivity.this,"你点了回车。",Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });



        /* 实现数据绑定自动完成输入框的步骤与Spinner相同。 */

        /*
        * 1.建立数据源
        * 可以在代码中动态建立，也可建为XML文档，再通过getResouce得到。
        */
        String[] contries = new String[]{
           "Ganbin","Gaoanbin","Gaoybin","Gaoyain","Gaanbin","Amrican","Bingo","CanYou","Define","East","Family","Gradle"
        } ;

        /*
        * 2.建立Adapter与数据源、布局文件的关联。
        */

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,contries);

        /* 设置AutoCompleteTextView的适配器。 */
        autoCompleteTextView.setAdapter(adapter);

        /* 默认为输入两个字母后才提示，设为0后只要输入一个字母就能提示了。 */
        autoCompleteTextView.setThreshold(0);

    }
}

















