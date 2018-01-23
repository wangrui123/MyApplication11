package com.example.internet;

import android.app.Application;

/**
 * author: wangrui
 * date : 2017/5/31
 * description :
 */

public class MyApplication extends Application {

    private static MyApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static MyApplication getInstance() {
        return mContext;
    }
}
