package com.example.internet.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.internet.R;

import java.util.List;

/**
 * author: wangrui
 * date : 2017/8/14
 * description :
 */

public class OtherAdapter extends BaseQuickAdapter<String> {


    public OtherAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String s) {
        holder.setText(R.id.tv_item, s);
    }
}
