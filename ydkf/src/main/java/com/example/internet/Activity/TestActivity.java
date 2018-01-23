package com.example.internet.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.internet.R;

public class TestActivity extends AppCompatActivity {


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
            }
        }
    };
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.button);
    }

    public void OnClick(View view) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                ToastUtils.showToast(TestActivity.this,"aaaaa");
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                mHandler.sendEmptyMessage(100);
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        ToastUtils.showToast(TestActivity.this, "aaaaa111");
//                    }
//                });
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//               runOnUiThread(new Runnable() {
//                   @Override
//                   public void run() {
//                       ToastUtils.showToast(TestActivity.this, "aaaaakkkk");
//                   }
//               });
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                button.post(new Runnable() {
                    @Override
                    public void run() {
//                        ToastUtils.showToast(TestActivity.this, "hhhhhhhhhh");
                    }
                });
            }
        }).start();
    }
}
