package com.blueicehunter.ui04_starderdview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.XMLReader;

import java.util.MissingFormatArgumentException;


public class MainActivity extends Activity {

    private TextView tv01,tv02,tv03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv01 = (TextView)findViewById(R.id.tv01);
        tv02 = (TextView)findViewById(R.id.tv02);
        tv03 = (TextView)findViewById(R.id.tv03);

        this.showTextViewByHtml();
        this.showTextViewBySpan();
        this.showTextViewByMarquee();

    }


    /**
     * 以HTML方式来格式化TextView中的内容。
     */
    private void showTextViewByHtml(){
        /*
        * 声明了一个接口对象,也是下面Html.fromHtml的第二个参数。
        * 这个对象就是根据<img>标签的src路径，来返回一个Drawable对象。可以从网络获取图片，也可以给本地图片。
        */
        Html.ImageGetter imageGetter = new Html.ImageGetter() {
            @Override
            /* source 参数就是<img>标签的src路径 */
            public Drawable getDrawable(String source) {
                BitmapDrawable _bitmap;

                if(source.equals("icon01.png")) {
                    _bitmap = (BitmapDrawable) getResources().getDrawable(R.drawable.icon01);
                    _bitmap.setBounds(0, 0, _bitmap.getIntrinsicWidth(), _bitmap.getIntrinsicHeight());
                    return _bitmap;
                }
                else{
                    _bitmap = (BitmapDrawable) getResources().getDrawable(R.drawable.icon02);
                    _bitmap.setBounds(0, 0, _bitmap.getIntrinsicWidth(), _bitmap.getIntrinsicHeight());
                    return _bitmap;
                }
            }
        };


        /*
        * 声明了一个接口对象,也是下面Html.fromHtml的第三个参数。
        * 这个对象就是通过XMLReader解析器去解析每一个Html标签，无论是已知的标签还是自定义的标签。
        * 并且每解析到一个标签handleTag()这个方法都会被执行。
        */
        Html.TagHandler tagHandler = new Html.TagHandler() {
            @Override
            public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
                Toast.makeText(MainActivity.this,tag,Toast.LENGTH_SHORT).show();
            }
        };



        /* 使用formHtml将文档按Html格式来显示，其中第二个参数是用来显示图片的 */
        tv01.setText(Html.fromHtml("" +
                        "<b>中国你好！！！</b>" +
                        "<sundy></sundy>" +
                        "<b>中国你好！！！</b>" +
                        "<img src='icon01.png'/>" +
                        "<b>美国你好！！！</b>" +
                        "<sundy></sundy>" +
                        "<b>美国你好！！！</b>" +
                        "<img src='icon02.png'/>" +
                        "<b>日本你好.....日本你好.....</b>",
                imageGetter,null));
    }


    /**
     * 以Span方式来格式化TextView中的内容。
     * SpannableStringBuilder方式就是将TextView中的内容进行片断化操作。就是从第几个到第几个字符做何种处理的一种方式。
     * 其中核心的方法就是setSpan() 将要进行处理的: 操作（Span对象）、开始位置、结束位置和是否包含关系传入其中。可以多次设置.
     * 再通过TextView的setText()传入设置好SpannableStringBuilder对象
     *
     * 操作Span对象主要有：继承自CharacterStyle的子类们，
     * 直接继承类：BackgroundColorSpan, ClickableSpan, ForegroundColorSpan, MaskFilterSpan, MetricAffectingSpan, RasterizerSpan, StrikethroughSpan, UnderlineSpan
     * 间接继承类：AbsoluteSizeSpan, DynamicDrawableSpan, ImageSpan, RelativeSizeSpan, ReplacementSpan, ScaleXSpan, StyleSpan, SubscriptSpan, SuperscriptSpan, TextAppearanceSpan, TypefaceSpan, URLSpan
     */
    private void showTextViewBySpan(){

        /* 只有加上其它形式的autoLink，clickableSpan才会起作用，不知为何。 */
        String str = "今天天气很好啊。 今天天气很好啊。 今天天气很好啊。今天天气很好啊。384401056@qq.com";
        SpannableStringBuilder spanBuilder = new SpannableStringBuilder(str);

        /* 定义两个插入图片的Span */
        ImageSpan imageSpan = new ImageSpan(MainActivity.this,R.drawable.icon01);
        ImageSpan imageSpan2 = new ImageSpan(MainActivity.this,R.drawable.icon02);

        /* 定义了一个改变背景色的Span */
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#00FF00"));

        /* 定义了一个改变前景色的Span */
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#00FFEE"));

        /*
        * 定义了一个文字点击的Span,要先设置 android:clickable="true"
        */
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this,"你点击了TextView",Toast.LENGTH_SHORT).show();
            }
        };

        /* 添加操作Span */
        spanBuilder.setSpan(imageSpan,8,9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanBuilder.setSpan(backgroundColorSpan,8,15, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spanBuilder.setSpan(imageSpan2,17,18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanBuilder.setSpan(foregroundColorSpan,18,25, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spanBuilder.setSpan(clickableSpan,0,33, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        tv02.setText(spanBuilder);
    }


    /**
     * 以路马灯的方式显示TextView中的内容
     */
    private void showTextViewByMarquee(){

        /* 只有加上其它形式的autoLink，clickableSpan才会起作用，不知为何。 */
        String str = "今天天气很好啊。 今天天气很好啊。 今天天气很好啊。今天天气很好啊。";
/*        SpannableStringBuilder spanBuilder = new SpannableStringBuilder(str);

        *//* 定义两个插入图片的Span *//*
        ImageSpan imageSpan = new ImageSpan(MainActivity.this,R.drawable.icon01);
        ImageSpan imageSpan2 = new ImageSpan(MainActivity.this,R.drawable.icon02);

        *//* 定义了一个改变背景色的Span *//*
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#00FF00"));

        *//* 定义了一个改变前景色的Span *//*
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#00FFEE"));

        *//*
        * 定义了一个文字点击的Span,要先设置 android:clickable="true"
        *//*
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this,"你点击了TextView",Toast.LENGTH_SHORT).show();
            }
        };

        *//* 添加操作Span *//*
        spanBuilder.setSpan(imageSpan,8,9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanBuilder.setSpan(backgroundColorSpan,8,15, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spanBuilder.setSpan(imageSpan2,17,18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanBuilder.setSpan(foregroundColorSpan,18,25, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        spanBuilder.setSpan(clickableSpan,0,33, Spannable.SPAN_INCLUSIVE_INCLUSIVE);*/

        tv03.setText("spanBuilder.setSpan(imageSpan,8,9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);");

    }
}
































