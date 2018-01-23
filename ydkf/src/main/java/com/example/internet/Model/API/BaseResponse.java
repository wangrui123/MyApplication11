package com.example.internet.Model.API;

import com.google.gson.annotations.SerializedName;

/**
 * author: wangrui
 * date : 2017/6/5
 * description :
 */

public class BaseResponse {
    @SerializedName("code")
    public int code;

    @SerializedName("msg")
    public String msg;

    @SerializedName("flg")
    public String flg;
}
