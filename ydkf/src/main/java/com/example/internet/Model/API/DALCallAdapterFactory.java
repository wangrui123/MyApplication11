package com.example.internet.Model.API;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author: wangrui
 * date : 2017/6/6
 * description :
 */

public class DALCallAdapterFactory extends CallAdapter.Factory {

    private final RxJavaCallAdapterFactory original;

    private DALCallAdapterFactory() {
        original = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    public static CallAdapter.Factory create() {
        return new DALCallAdapterFactory();
    }

    @Override
    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return new RxCallAdapterWrapper(retrofit, original.get(returnType, annotations, retrofit));
    }

    private static class RxCallAdapterWrapper implements CallAdapter<Observable<?>> {
        private final Retrofit retrofit;
        private final CallAdapter<?> wrapped;

        public RxCallAdapterWrapper(Retrofit retrofit, CallAdapter<?> wrapped) {
            this.retrofit = retrofit;
            this.wrapped = wrapped;
        }

        @Override
        public Type responseType() {
            return wrapped.responseType();
        }

        @SuppressWarnings("unchecked")
        @Override
        public <R> Observable<?> adapt(Call<R> call) {
            return ((Observable) wrapped.adapt(call)).onErrorResumeNext(e -> {
                Log.e("APIError", e.toString());
                return Observable.error(new Throwable("网络有问题!"));
            }).flatMap(x -> {
                if (x instanceof BaseResponse && ((BaseResponse) x).code != 50000) {
                    String message = ((BaseResponse) x).msg;
                    if (((BaseResponse) x).msg != null) {
                        message = ((BaseResponse) x).msg;
                    }
                    Throwable state = new Throwable(String.valueOf(((BaseResponse) x).code));
                    return Observable.error(new Throwable(message, state));
                }
                return Observable.just(x);
            }).observeOn(AndroidSchedulers.mainThread());
        }
    }

}
