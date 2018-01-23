package com.example.internet.Activity;

import android.support.v4.app.Fragment;

import com.example.internet.Fragment.ListTitleFragment;
import com.example.internet.Fragment.SingleFragmentActivity;

public class ListTitleActivity extends SingleFragmentActivity {

    private ListTitleFragment mListFragment;

    @Override
    protected Fragment createFragment() {
        mListFragment = new ListTitleFragment();
        return mListFragment;
    }
}
