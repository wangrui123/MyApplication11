package com.example.internet.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chiclam.android.updater.Updater;
import com.chiclam.android.updater.UpdaterConfig;
import com.example.internet.R;
import com.example.internet.Utils.CustomTitlebar;
import com.example.internet.Utils.FileUtils;

import butterknife.BindView;


/**
 * author: wangrui
 * date : 2017/7/3
 * description :登录
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.textView)
    TextView textView;

    private Bundle bundle;
    private String path;


    @Override
    public void setOnClick() {
        textView.setOnClickListener(v -> {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    String s = FileUtils.readFile2(this, "cn.srt");
                    StringBuilder s1 = new StringBuilder();
                    String[] arr = new String[s.length()];
                    textView.setText(s);
                    for (int i = 0; i < arr.length; i++) {
                        s1.append(s);
//                        arr[i] = s.substring(i, i + 1);
                        Log.e("gggggg", s1 + "");
                    }

                }
            }

        });
    }

    @Override
    public int initLayout() {
        return R.layout.login_activity;
    }

    @Override
    public void initView() {
        textView.setText("ooooo");
        CustomTitlebar customTitlebar1 = (CustomTitlebar) findViewById(R.id.title1);
        customTitlebar1.setTilte("ttttttt");
        CustomTitlebar customTitlebar2 = (CustomTitlebar) findViewById(R.id.title2);
        CustomTitlebar customTitlebar3 = (CustomTitlebar) findViewById(R.id.title3);
        CustomTitlebar customTitlebar4 = (CustomTitlebar) findViewById(R.id.title4);
        customTitlebar1.setAction(new CustomTitlebar.TitleBarOnClickListener() {
            @Override
            public void performAction(View view) {
                switch (view.getId()) {
                    case R.id.iv_left:
                        Toast.makeText(LoginActivity.this, "左边图片按钮", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        customTitlebar2.setAction(new CustomTitlebar.TitleBarOnClickListener() {
            @Override
            public void performAction(View view) {
                switch (view.getId()) {
                    case R.id.iv_left:
                        Toast.makeText(LoginActivity.this, "左边图片按钮", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_right:
                        Toast.makeText(LoginActivity.this, "右边文字按钮", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        customTitlebar3.setAction(new CustomTitlebar.TitleBarOnClickListener() {
            @Override
            public void performAction(View view) {
                switch (view.getId()) {
                    case R.id.iv_left:
                        Toast.makeText(LoginActivity.this, "左边图片按钮", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.iv_right:
                        Toast.makeText(LoginActivity.this, "右边图片按钮", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        customTitlebar4.setAction(new CustomTitlebar.TitleBarOnClickListener() {
            @Override
            public void performAction(View view) {
                switch (view.getId()) {
                    case R.id.tv_left:
                        Toast.makeText(LoginActivity.this, "左边文字按钮", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_right:
                        Toast.makeText(LoginActivity.this, "右边文字按钮", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void initData() {
        initToolBar("bbbbbb");
        setSlideOut(true);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.textView:
                UpdaterConfig config = new UpdaterConfig.Builder(this)
                        .setTitle(getResources().getString(R.string.app_name))
                        .setDescription(getString(R.string.system_download_description))
                        .setFileUrl("")
                        .setCanMediaScanner(true)
                        .build();
                Updater.get().showLog(true).download(config);
//                RegisterActivity.startActivity(this);
                break;
        }
    }


}
