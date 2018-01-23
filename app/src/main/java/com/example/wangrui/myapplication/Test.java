package com.example.wangrui.myapplication;

import android.content.Context;

/**
 * author: wangrui
 * date : 2017/5/16
 * description :
 */

public class Test {
    public static void main(String args[]) {
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
