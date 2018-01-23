package com.example.internet.Activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.internet.R;
import com.example.internet.Utils.PreventClicks;
import com.example.internet.Utils.ScreenWH;
import com.example.internet.Utils.ToastUtils;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * author: wangrui
 * date : 2017/7/3
 * description :Activity基类
 */

public abstract class BaseActivity extends SwipeBackActivity implements View.OnClickListener,EasyPermissions.PermissionCallbacks {

    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = true;
    /**
     * 是否禁止旋转屏幕
     **/
    private boolean isAllowScreenRoate = true;

    /**
     * 是否输出日志信息
     **/
    private boolean isDebug = true;
    private final String TAG = this.getClass().getSimpleName();
//    private Unbinder bind;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean isSlideOut = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
//        bind = ButterKnife.bind(this);//注解
        if (isSetStatusBar) {
            steepStatusBar();
        }
        if (isAllowScreenRoate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//默认强制限制竖屏
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//限制横屏
        }
        initView();
        initData();
        setOnClick();
        setSlip();
    }

    private void setSlip() {
        //可以调用该方法，设置是否允许滑动退出
        setSwipeBackEnable(isSlideOut);
        mSwipeBackLayout = getSwipeBackLayout();
//            // 设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
//            // 滑动退出的效果只能从边界滑动才有效果，如果要扩大touch的范围，可以调用这个方法
        mSwipeBackLayout.setEdgeSize(ScreenWH.getScreenWidth(this) / 3);
    }

    public void setSlideOut(boolean isSlideOut) {
        this.isSlideOut = isSlideOut;
    }

    /**
     * [沉浸状态栏]
     */
    private void steepStatusBar() {
//        ScreenWH.setTraspartenStatusBar(this);
//        StatusBarUtil.setColor(this, Color.TRANSPARENT);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorCyan), 15);
    }

    /**
     * [初始化监听事件]
     */
    public abstract void setOnClick();

    /**
     * [绑定布局]
     */
    public abstract int initLayout();

    /**
     * [初始化控件]
     */
    public abstract void initView();

    /**
     * [业务操作]
     */
    public abstract void initData();

    /**
     * [View点击逻辑处理]
     **/
    public abstract void widgetClick(View v);


    /**
     * [日志输出]
     */
    public void Log(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }

    /**
     * [Toast弹出]
     */
    public void showToast(String content) {
        ToastUtils.showToast(content);
    }

    /**
     * [防止用户连续点击]
     */
    @Override
    public void onClick(View v) {
        if (PreventClicks.isFastClick())
            widgetClick(v);
    }


    /**
     * [统一初始化[titlebar]
     */
    public void initToolBar(String title) {
//        ImageView ivBack = (ImageView) findViewById(R.id.iv_back);
//        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
//        tvTitle.setText(title);
//        ivBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (PreventClicks.isFastClick())
//                    finish();
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        bind.unbind();
    }


    private Map<Integer, PermissionCallback> mPermissonCallbacks = null;
    private Map<Integer, String[]> mPermissions = null;

    protected interface PermissionCallback {
        void hasPermission(List<String> allPerms);
        void noPermission(List<String> deniedPerms, List<String> grantedPerms, Boolean hasPermanentlyDenied);
    }

    protected void performCodeWithPermission(@NonNull String rationale,
                                             final int requestCode, @NonNull String[] perms, @NonNull PermissionCallback callback) {
        if (EasyPermissions.hasPermissions(this, perms)) {
            callback.hasPermission(Arrays.asList(perms));
        } else {
            if(mPermissonCallbacks == null) {
                mPermissonCallbacks = new HashMap<>();
            }
            mPermissonCallbacks.put(requestCode, callback);

            if(mPermissions == null) {
                mPermissions = new HashMap<>();
            }
            mPermissions.put(requestCode, perms);

            EasyPermissions.requestPermissions(this, rationale, requestCode, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if(mPermissonCallbacks == null || !mPermissonCallbacks.containsKey(requestCode)) {
            return;
        }
        if(mPermissions == null || !mPermissions.containsKey(requestCode)) {
            return;
        }

        // 100% granted permissions
        if(mPermissions.get(requestCode).length == perms.size()) {
            mPermissonCallbacks.get(requestCode).hasPermission(Arrays.asList(mPermissions.get(requestCode)));
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if(mPermissonCallbacks == null || !mPermissonCallbacks.containsKey(requestCode)) {
            return;
        }
        if(mPermissions == null || !mPermissions.containsKey(requestCode)) {
            return;
        }

        //granted permission
        List<String> grantedPerms = new ArrayList<>();
        for(String perm : mPermissions.get(requestCode)) {
            if(!perms.contains(perm)) {
                grantedPerms.add(perm);
            }
        }
        //check has permission denied permanently
        if(EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            mPermissonCallbacks.get(requestCode).noPermission(perms, grantedPerms, true);
        } else {
            mPermissonCallbacks.get(requestCode).noPermission(perms, grantedPerms, false);
        }
    }

    /**
     * alert AppSet Permission
     * @param rationale alert setting rationale
     */
    protected void alertAppSetPermission(String rationale) {
        new AppSettingsDialog.Builder(this, rationale)
                .setTitle("ddd")
                .setPositiveButton("eee")
                .setNegativeButton("fff", null)
                .build()
                .show();
    }

    /**
     * alert AppSet Permission
     * @param rationale alert setting rationale
     * @param requestCode onActivityResult requestCode
     */
    protected void alertAppSetPermission(String rationale, int requestCode) {
        new AppSettingsDialog.Builder(this, rationale)
                .setTitle("请申请读写和相机和录音权限")
                .setPositiveButton("确定")
                .setNegativeButton("取消", null)
                .setRequestCode(requestCode)
                .build()
                .show();
    }
}
