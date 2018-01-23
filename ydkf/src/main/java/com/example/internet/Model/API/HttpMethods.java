package com.example.internet.Model.API;

import com.example.internet.MyApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.BuildConfig;


/**
 * author: wangrui
 * date : 2017/5/31
 * description :
 */

public class HttpMethods {

    //    private static final String BASE_URL = "http://127.0.0.1:50112/web/rest/";http://47.96.140.207:9080/ftns-push/test/test1
    private static final int DEFAULT_TIMEOUT = 54000;
    private Retrofit retrofit;
    private MyService movieService;

    private static final String BASE_URL = "http://47.96.140.207:9080/";

    //设置缓存目录
    private static File cacheDirectory = new File(MyApplication.getInstance().getCacheDir().getAbsolutePath(), "MyCache");
    private static Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);

    //先构造私有的构造方法
    private HttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        if (movieService == null) {
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClientBuilder.interceptors().add(interceptor);
            }
            retrofit = new Retrofit.Builder()
                    .client(httpClientBuilder.build())//设置使用okhttp网络请求
                    .addConverterFactory(GsonConverterFactory.create())//添加转化库，默认是Gson
                    .addCallAdapterFactory(DALCallAdapterFactory.create())//添加回调库，采用RxJava
                    .baseUrl(BASE_URL).build();//设置服务器路径
            movieService = retrofit.create(MyService.class);
        }
    }

    //创建单例
    public static class SingleonHolder {
        private static final HttpMethods instance = new HttpMethods();
    }

    //获取单例
    public static MyService getInstance() {
        return SingleonHolder.instance.movieService;
    }

}
