package com.example.wangrui.myapplication;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * author: wangrui
 * date : 2017/11/24
 * description :
 */

public class LeakApplication extends Application {

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher= setupLeakCanary();
    }

    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        LeakApplication leakApplication = (LeakApplication) context.getApplicationContext();
        return leakApplication.refWatcher;
    }

}
