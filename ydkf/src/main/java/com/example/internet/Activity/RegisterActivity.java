package com.example.internet.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.internet.R;

public class RegisterActivity extends BaseActivity {


    @Override
    public void setOnClick() {

    }

    @Override
    public int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void widgetClick(View v) {

    }


    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, RegisterActivity.class);
        context.startActivity(intent);
    }
}
