package com.example.internet.weight;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * author: wangrui
 * date : 2017/8/15
 * description :
 */

public class TouchTextView extends TextView {

    public TouchTextView(Context context) {
        super(context);
    }

    public TouchTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("View", "dispatchTouchEvent---"+event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("View", "onTouchEvent---"+event.getAction());
        return super.onTouchEvent(event);
    }
}
