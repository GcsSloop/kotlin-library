package com.gcssloop.kotlinlibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gcssloop.apputils.getVersionCode
import com.gcssloop.apputils.getVersionName
import com.gcssloop.apputils.isInDebug
import com.gcssloop.apputils.isInstall

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pkgName = "com.tencent.mm"

        Log.i(TAG, "ThisVersionName:" + getVersionName())
        Log.i(TAG, "ThisVersionCode:" + getVersionCode())
        Log.i(TAG, "WeChatVersionName:" + getVersionName(pkgName))
        Log.i(TAG, "WeChatVersionCode:" + getVersionCode(pkgName))
        Log.i(TAG, "isInstall:" + isInstall(pkgName))
        Log.i(TAG, "isDebug:" + isInDebug())
        Log.i(TAG, "isDebug:" + isInDebug(pkgName))
    }
}
