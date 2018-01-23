package com.example.internet.Adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.internet.Model.Bean.MultipleItem;

import java.util.List;

/**
 * author: wangrui
 * date : 2017/9/1
 * description :
 */

public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem> {

    public MultipleItemQuickAdapter(List<MultipleItem> data) {
        super(data);
//        addItmeType(MultipleItem.TYPE_DATA, R.layout.view_rv_item);
//        addItmeType(MultipleItem.TYPE_HEADER, R.layout.view_rv_item);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MultipleItem multipleItem) {

    }
}
