package com.example.internet.Activity;

import android.support.v4.app.Fragment;

import com.example.internet.Fragment.ContentFragment;
import com.example.internet.Fragment.SingleFragmentActivity;

public class ContentActivity extends SingleFragmentActivity {
    private ContentFragment mContentFragment;

    @Override
    protected Fragment createFragment() {
        String title = getIntent().getStringExtra(ContentFragment.ARGUMENT);
        mContentFragment = ContentFragment.newInstance(title);
        return mContentFragment;
    }
}
