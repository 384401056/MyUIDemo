package com.blueice.ui13;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;



public class MainActivity extends ListActivity {


    private ListView lv;
    private String[] data;
    private Handler mProgressHandler;
    private int mProgress;

    private Dialog dialog;
    private AlertDialog alertDialog;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lv = getListView();
        data = new String[]{"Dialog","AlertDialog","ProgressDialog1","ProgressDialog2","CustomDislog"};

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);

        setListAdapter(adapter);


        /* 通过消息对列来增加ProgressBar的进度。 */
        mProgressHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(mProgress>=100){
                    progressDialog.dismiss();
                }else{
                    mProgress++;
                    progressDialog.incrementProgressBy(1);
                    mProgressHandler.sendEmptyMessageDelayed(0,200);
                }

            }
        };

    }


    /* ListViwe点击事件。 */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case 0:
                showDialog(0);
                break;
            case 1:
                showDialog(1);
                break;
            case 2:
                showDialog(2);
                break;
            case 3:
                showDialog(3);
                mProgress = 0;
                progressDialog.setProgress(0);
                mProgressHandler.sendEmptyMessage(0);
                break;
            default:
                break;

        }

    }


    /* 创建对话框事件 */
    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id){
            case 0:
                dialog = new Dialog(this);
                dialog.setTitle("Dialg");
                dialog.setContentView(R.layout.dialog);
                dialog.setCanceledOnTouchOutside(true);
                dialog.findViewById(R.id.dialog_btn01).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"点击了Yes",Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.findViewById(R.id.dialog_btn02).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"点击了No",Toast.LENGTH_SHORT).show();
                    }
                });

                return dialog;

            case 1:
                alertDialog = new AlertDialog.Builder(this)
                        .setTitle("AlertDialog")
                        .setMessage("This a AlertDialg")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了Yes", Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "点击了No", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                return alertDialog;
            case 2:
                progressDialog = new ProgressDialog(this);
//                progressDialog.setTitle("ProgressDialog");
//                progressDialog.setIconAttribute(android.R.attr.alertDialogIcon);
                progressDialog.setCanceledOnTouchOutside(true);
                progressDialog.setMessage("正在加载中....");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);/* 圆形进度条 */

                return progressDialog;

            case 3:
                progressDialog = new ProgressDialog(this);
//                progressDialog.setTitle("ProgressDialog");
                progressDialog.setIconAttribute(android.R.attr.alertDialogIcon);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); /* 水平进度条 */
                progressDialog.setProgressNumberFormat(null); /* 不显示剩余数和总数 */
//                progressDialog.setProgressPercentFormat(null); /* 不显示百分比。 */

                progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE,"取消",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                return progressDialog;

        }

        return null;


    }


}























