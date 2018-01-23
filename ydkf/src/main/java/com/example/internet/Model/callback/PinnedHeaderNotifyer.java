package com.example.internet.Model.callback;

public interface PinnedHeaderNotifyer<T> {

    boolean isPinnedHeaderType(int viewType);

    T getPinnedHeaderInfo(int position);

}
