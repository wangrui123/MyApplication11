package com.example.internet.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.internet.Activity.BaseActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: wangrui
 * date : 2017/7/7
 * description :BaseFragmnet基类
 */

public abstract class BaseFragment extends Fragment {

    private BaseActivity mActivity;
    private Unbinder bind;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getContentViewLayoutID() != 0) {
            return inflater.inflate(getContentViewLayoutID(), null);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        initViews(view);
    }


    //获取宿主Activity
    public BaseActivity getHoldingActivity() {
        return mActivity;
    }

//    //添加fragment
//    protected void addFragment(BaseFragment fragment) {
//        if (null != fragment) {
//            getHoldingActivity().addFragment(fragment);
//        }
//    }
//
//    //移除fragment
//    protected void removeFragment() {
//        getHoldingActivity().removeFragment();
//    }


    /**
     * 打开一个Activity 默认 不关闭当前activity
     */
    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(mActivity, clz);
        if (ex != null) {
            intent.putExtras(ex);
        }
        startActivity(intent);
        if (isCloseCurrentActivity) {
            mActivity.finish();
        }
    }

    @Override
    public void onDestroy() {
        bind.unbind();
        super.onDestroy();
    }


    protected abstract void initViews(View view);

    protected abstract int getContentViewLayoutID();

}
