package com.example.internet.Utils;

import android.content.Context;

/**
 * author: wangrui
 * date : 2017/7/3
 * description :单例模式正确姿势
 */

public class SingleMode {

    //    private static volatile SingleMode singleMode = null;
    private static Context context;

    //私有的构造函数
    private SingleMode(Context context) {
        this.context = context.getApplicationContext();
    }
//
//    public static SingleMode getInstance(Context context) {
//        if (singleMode == null) {
//            synchronized (SingleMode.class) {
//                if (singleMode == null) {
//                    singleMode = new SingleMode(context);
//                }
//            }
//        }
//        return singleMode;
//    }
//
//    private SingleMode() {
//    }

    public static final SingleMode getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //定义的静态内部类
    private static class SingletonHolder {
        private static final SingleMode INSTANCE = new SingleMode(context);//创建实例的地方
    }
}
