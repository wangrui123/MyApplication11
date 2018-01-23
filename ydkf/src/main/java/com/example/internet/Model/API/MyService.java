package com.example.internet.Model.API;

import com.example.internet.Model.Bean.GetCbdDetailsIn;
import com.example.internet.Model.Bean.GetCbdDetailsOut;
import com.example.internet.Model.Bean.LoginIn;
import com.example.internet.Model.Bean.LoginResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * author: wangrui
 * date : 2017/6/8
 * description :
 */

public interface MyService {
    //催办单详情
    @POST("hurrydoonedetailsAction")
    Observable<GetCbdDetailsOut> getCbdDetailsList(@Body GetCbdDetailsIn getCbdListIn);


    //登录获取个人信息
    @POST("ftns-push/test/test1")
    Observable<LoginResponse> login(@Body LoginIn entity);
}
