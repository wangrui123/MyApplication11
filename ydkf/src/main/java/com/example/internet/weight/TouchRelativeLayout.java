package com.example.internet.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * author: wangrui
 * date : 2017/8/15
 * description :
 */

public class TouchRelativeLayout extends RelativeLayout {

    public TouchRelativeLayout(Context context) {
        super(context);
    }

    public TouchRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("ViewGroup","dispatchTouchEvent---"+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("ViewGroup", "onInterceptTouchEvent---"+ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("ViewGroup","onTouchEvent---"+event.getAction());
        return false;
    }
}
