package com.example.internet.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.internet.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: wangrui
 * date : 2017/7/19
 * description :
 */

public class OtherFragment extends Fragment {

//    @BindView(R.id.recyclerView2)
//    RecyclerView rView;

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.other_fragment, container, false);
        bind = ButterKnife.bind(this, view);
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        OtherAdapter otherAdapter = new OtherAdapter(R.layout.other_fragment_item,getData());
//        rView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        otherAdapter.isFirstOnly(false); //设置不仅是首次填充数据时有动画,以后上下滑动也会有动画
//        //有5种动画可以设置,但若是多类型数据时,可能只有第一种类型(第0ViewType)数据有动画效果,也许被看成了单类型了
//        otherAdapter.openLoadAnimation(BaseMultiItemQuickAdapter.SLIDEIN_LEFT);
//        rView.setAdapter(otherAdapter);
    }

    private List<String> getData() {
        List<String> data = new ArrayList<>();
        String temp = "w";
        for (int i = 0; i < 30; i++) {
            data.add(i + temp);
        }
        return data;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
