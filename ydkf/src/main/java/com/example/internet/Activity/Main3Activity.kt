package com.example.internet.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.internet.R

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }

    private fun initData() {
        val bundle = Bundle()
        val data = bundle.getString("aaa")
        Log.e("qqqqq", data)
    }
}
