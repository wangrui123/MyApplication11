package com.example.internet.Model.callback;

import android.view.View;

public interface OnItemClickListener<T> {

    void onItemClick(View view, T data, int position);

}
