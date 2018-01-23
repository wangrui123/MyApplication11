package com.example.internet.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.internet.Adapter.MyAdapter;
import com.example.internet.R;
import com.example.internet.Utils.DividerGridItemDecoration;
import com.example.internet.Utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: wangrui
 * date : 2017/7/19
 * description :
 */

public class MyFragment extends Fragment {

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    private Unbinder bind;
    private Activity mActivity;
    private MyAdapter mAdpter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setOnClick();
    }

    private void setOnClick() {
        mAdpter.setOnItemClickLitener(new MyAdapter.onRecyclerViewItemClick() {
            @Override
            public void onItemClick(View v, int position) {
//                mAdpter.addNewItem(position);
                ToastUtils.showToast(position+"");
            }

            @Override
            public void onLongItemClick(View v, int position) {
//                mAdpter.deleteItem(position);
                ToastUtils.showToast(position+"");
            }
        });
    }

    private void initView() {
        mAdpter = new MyAdapter(getData(), mActivity);
//        mRecyclerView.setLayoutManager( new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                StaggeredGridLayoutManager.VERTICAL));
//        mRecyclerView.addItemDecoration(new GridItemDecoration.Builder(mActivity).size(R.dimen.x1).color(R.color.colorAccent)
//                .margin(R.dimen.x1, R.dimen.x1).isExistHead(true).build());
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity,4));
        mRecyclerView.setAdapter(mAdpter);
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity()));//分割线
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


    }


    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = "item";
        for (int i = 0; i < 30; i++) {
            data.add(i + temp);
        }
        return data;
}


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.id_action_add:
//                mStaggeredHomeAdapter.addData(1);
//                break;
//            case R.id.id_action_delete:
//                mStaggeredHomeAdapter.removeData(1);
//                break;
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
