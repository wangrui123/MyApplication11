package com.example.internet.Module;

import android.util.Log;

import com.example.internet.Model.API.HttpMethods;
import com.example.internet.Model.Bean.GetCbdDetailsIn;
import com.example.internet.Model.Bean.GetCbdDetailsOut;
import com.example.internet.Model.Bean.LoginIn;
import com.example.internet.Model.Bean.LoginResponse;

import rx.Observable;
import rx.functions.Func1;

/**
 * author: wangrui
 * date : 2017/6/5
 * description :
 */

public class WorkModel {

    public  Observable<GetCbdDetailsOut> getBzrwdDetails(String cbdId,String password) {
        GetCbdDetailsIn entity = new GetCbdDetailsIn();
//        entity.setBh(cbdId);
        entity.setPassword("11111");
        entity.setPhone("150");
        return HttpMethods.getInstance().getCbdDetailsList(entity).map(new Func1<GetCbdDetailsOut, GetCbdDetailsOut>() {
            @Override
            public GetCbdDetailsOut call(GetCbdDetailsOut getCbdListOut) {
                if (getCbdListOut.code == 50000) {
                    Log.e("getCbdListOut",getCbdListOut.toString());
                    return getCbdListOut;
                }
                return null;
            }
        });
    }
    public Observable<LoginResponse> login(LoginIn entity) {
        return HttpMethods.getInstance().login(entity);
    }

}
