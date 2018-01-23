package com.example.internet.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.internet.Fragment.MyFragment;
import com.example.internet.Fragment.OtherFragment;
import com.example.internet.Model.Bean.LoginIn;
import com.example.internet.Model.Bean.LoginResponse;
import com.example.internet.Module.WorkModel;
import com.example.internet.R;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private FragmentManager fm;
    private ArrayAdapter<String> adapter;
    private String[] tabs = new String[]{"我的", "其他"};
    private List<Fragment> fragments;

    private OtherFragment readFragment;
    private MyFragment newsFragment;
    private WorkModel workModel = new WorkModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initFragments();
        initOnClick();
//        request();
//        goLogin("");
    }

    private void initData() {
        Bundle bundle = new Bundle();
        String data = bundle.getString("aaa");
    }

    private void initFragments() {
        fragments = new ArrayList<Fragment>();
        MyFragment newsFragment = new MyFragment();
        fragments.add(newsFragment);
        OtherFragment readFragment = new OtherFragment();
        fragments.add(readFragment);
        ChangeAddFragment(0);
    }


    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) super.findViewById(R.id.left_drawer);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tabs);
        listView.setAdapter(adapter);
    }


    private void initOnClick() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDrawerLayout();
//                FragmentTransaction tran  = getSupportFragmentManager().beginTransaction();
//                hideFragment(tran);//隐藏已经add的fragment
                switch (position) {
                    case 0:
                        ChangeAddFragment(0);
//                        if (newsFragment == null){
//                            newsFragment = new MyFragment();
//                            tran.add(R.id.content_frame,newsFragment);
//                        }else{
//                            tran.show(newsFragment);
//                        }
                        break;
                    case 1:
                        ChangeAddFragment(1);
//                        if (readFragment == null){
//                            readFragment = new OtherFragment();
//                            tran.add(R.id.content_frame,readFragment);
//                        }else{
//                            tran.show(readFragment);
//                        }
                        break;
                }
//                tran.commit();
            }

            /**
             * 隐藏已经初始化的Fragment
             */
            private void hideFragment(FragmentTransaction tran) {
                if (newsFragment != null) {
                    tran.hide(newsFragment);
                }
                if (readFragment != null) {
                    tran.hide(readFragment);
                }
            }
        });
//       drawerLayout.openDrawer(Gravity.LEFT);//侧滑打开  不设置则不会默认打开
    }

    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

    private int preindex;

    private void ChangeAddFragment(int index) {
        Fragment fragment = fragments.get(index);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            ft.add(R.id.content_frame, fragment);
        }
        ft.hide(fragments.get(preindex));
        ft.show(fragments.get(index));
        preindex = index;
        ft.commit();
    }


    private void request() {

        workModel.getBzrwdDetails("033d5438-06e7-4ec3-b7dc-3b75040d0e32", "")
                .subscribe(tour -> {

                }, e -> {

                });
    }


    private void goLogin(String account) {
        LoginIn loginIn = new LoginIn();
        loginIn.setPhone("150");
        loginIn.setPassword("11111");
        workModel.login(loginIn).map(new Func1<LoginResponse, Boolean>() {
            @Override
            public Boolean call(LoginResponse loginResponse) {
                String password = loginResponse.getPassword();
                String phone = loginResponse.getPhone();
                Log.e("成功","成功" +password+"--------"+phone);
                return false;
            }
        }).subscribe(aBoolean -> {
            Log.e("成功1","成功1");
        }, e -> {
            Log.e("失败","失败");
        });

    }
}
