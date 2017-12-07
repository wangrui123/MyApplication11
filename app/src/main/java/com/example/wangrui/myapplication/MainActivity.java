package com.example.wangrui.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.fragmentaddtest.MainViewActivity;
import com.squareup.leakcanary.RefWatcher;

public class MainActivity extends AppCompatActivity {

    private TextView imageview;
    private HandleUtils.HandlerHolder handlerHolder;
    private static final int M_ONE = 12;
    private static final int M_TWO = 14;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        initView();
        initData();
    }

    public void  onClick(View view){
        Intent intent = new Intent();
        intent.setClass(this,MainViewActivity.class);
        startActivity(intent);
    }

    private void initView() {
        imageview = (TextView) findViewById(R.id.imageview);
    }

    private void initData() {
        LeakThread leakThread = new LeakThread();
        leakThread.start();

//        WeakHandler wh = new WeakHandler();
//        wh.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                imageview.setVisibility(View.GONE);
//            }
//        }, 50000);
//        handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    imageview.setVisibility(View.GONE);
//                }
//            },50000);
//        finish();
//        handlerHolder = new HandleUtils.HandlerHolder(new HandleUtils.OnReceiveMessageListener() {
//            @Override
//            public void handlerMessage(Message msg) {
//                switch (msg.what) {
//                    case M_ONE:
//                        imageview.setVisibility(View.GONE);
//                        Toast.makeText(MainActivity.this, "M_ONE", Toast.LENGTH_SHORT).show();
//                        break;
//                    case M_TWO:
//                        Toast.makeText(MainActivity.this, "M_TWO", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });
//        handlerHolder.sendEmptyMessage(M_ONE);
//        handlerHolder.sendEmptyMessage(M_TWO);
    }

    static class LeakThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(6 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "onDestroy");
//        handler.removeCallbacksAndMessages(null);
//        handler = null;
        RefWatcher refWatcher = LeakApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }
}
