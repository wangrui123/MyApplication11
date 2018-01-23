package com.example.internet.Utils;

import android.widget.Toast;

import com.example.internet.MyApplication;

/**
 * author: wangrui
 * date : 2017/7/3
 * description :吐司的使用
 */
public class ToastUtils {
    private static Toast toast;

    public static void showToast(final String text) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getInstance(), "", Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }
}
