package com.example.internet.Activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.internet.Adapter.OtherAdapter;
import com.example.internet.R;
import com.example.internet.Utils.RxBusUtil;

import java.util.ArrayList;
import java.util.List;

import rx.subscriptions.CompositeSubscription;

public class SettingActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<String> list = new ArrayList();
    private CompositeSubscription allSubscription = new CompositeSubscription();

    @Override
    public void setOnClick() {

    }

    @Override
    public int initLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        setSlideOut(false);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        for (int i = 0; i < 50; i++) {
            list.add("第" + i + "数据");
        }
        OtherAdapter otherAdapter = new OtherAdapter(R.layout.other_fragment_item, list);
        otherAdapter.openLoadAnimation();  //默认为渐显效果
//        otherAdapter.isFirstOnly(false); //设置不仅是首次填充数据时有动画,以后上下滑动也会有动画
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(otherAdapter);

        otherAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent();
                RxBusUtil.getDefault().post("hello bus");
                intent.setClass(SettingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        otherAdapter.setOnRecyclerViewItemLongClickListener(new BaseQuickAdapter.OnRecyclerViewItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View view, int i) {
                return true;
            }
        });
    }
    class OneEvent {
        String msg;

        public OneEvent(String msg) {
            this.msg = msg;
        }
    }
    @Override
    public void initData() {
        allSubscription.add(RxBusUtil.getDefault()
                .toObserverable(OneEvent.class).subscribe(this::response));
    }

    private void response(OneEvent event) {
//        ToastUtils.showToast(this,event.msg);
    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (allSubscription != null && !allSubscription.isUnsubscribed())
            allSubscription.unsubscribe();
    }
}
