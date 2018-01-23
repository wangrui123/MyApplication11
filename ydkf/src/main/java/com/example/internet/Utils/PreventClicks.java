package com.example.internet.Utils;

/**
 * author: wangrui
 * date : 2017/7/3
 * description :防止用户连续点击按钮
 */

public class PreventClicks {

    // 两次点击按钮之间的点击间隔不能少于5000毫秒
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private static long lastClickTime;

    public static boolean isFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = curClickTime;
        return flag;
    }

}
