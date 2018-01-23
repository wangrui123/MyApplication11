package com.example.internet.Utils;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * author: wangrui
 * date : 2017/9/7
 * description :RxBus的使用
 */

public class RxBusUtil {

    private static volatile RxBusUtil instance;
    private final Subject<Object, Object> BUS;

    private RxBusUtil() {
        BUS = new SerializedSubject<>(PublishSubject.create());
    }

    public static RxBusUtil getDefault() {
        if (instance == null) {
            synchronized (RxBusUtil.class) {
                if (instance == null) {
                    instance = new RxBusUtil();
                }
            }
        }
        return instance;
    }

    public void post(Object event) {
        BUS.onNext(event);
    }

    public <T> Observable<T> toObserverable(Class<T> eventType) {
        // ofType = filter + cast
        return BUS.ofType(eventType);
    }
}
