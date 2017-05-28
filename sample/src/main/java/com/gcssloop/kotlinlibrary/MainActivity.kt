package com.gcssloop.kotlinlibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gcssloop.apputils.*
import com.gcssloop.fileutils.*
import java.io.FileInputStream
import java.io.Serializable
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 微信的包名
        val pkgName = "com.tencent.mm"

        // 获取版本名和版本号
        Log.i(TAG, "ThisVersionName:" + getVersionName())
        Log.i(TAG, "ThisVersionCode:" + getVersionCode())
        Log.i(TAG, "WeChatVersionName:" + getVersionName(pkgName))
        Log.i(TAG, "WeChatVersionCode:" + getVersionCode(pkgName))

        // 判断应用是否安装
        Log.i(TAG, "isInstall:" + isInstall(pkgName))

        // 判断应用是否处于debug状态，不传参数则判断当前应用
        Log.i(TAG, "isDebug:" + isInDebug())
        Log.i(TAG, "isDebug:" + isInDebug(pkgName))

        // 判断当前设备是否是平板
        Log.i(TAG, "isTablet:" + isTablet())

        // 打开Activity
        openActivity(SeccondActivity().javaClass)

        // 打开Activity并附带若干信息
        val data1 = LinkedHashMap<String, Serializable>()
        data1.put("title", "标题")
        openActivity(SeccondActivity().javaClass, data1)

        // 打开Activity并附带一个Bundle
        val data2 = Bundle()
        data2.putString("data", "数据")
        openActivity(SeccondActivity().javaClass, "bundle", data2)


        // 获取文件存储路径，支持自定义路径，不论怎么传递路径都行
        Log.i(TAG, "fileDir:" + getFileDir())
        Log.i(TAG, "fileDir:" + getFileDir("/"))
        Log.i(TAG, "fileDir:" + getFileDir("/hello"))
        Log.i(TAG, "fileDir:" + getFileDir("hello/"))
        Log.i(TAG, "fileDir:" + getFileDir("/hello/"))
        Log.i(TAG, "fileDir:" + getFileDir("hello/test"))
        Log.i(TAG, "fileDir:" + getFileDir("/hello/test"))
        Log.i(TAG, "fileDir:" + getFileDir("/hello/test/"))

        Log.i(TAG, "cacheDir:" + getCacheDir())
        Log.i(TAG, "cacheDir:" + getCacheDir("/hello"))

        Log.i(TAG, "externalFileDir:" + getExternalFileDir())
        Log.i(TAG, "externalFileDir:" + getExternalFileDir("hello"))


        Log.i(TAG, "externalCacheDir:" + getExternalCacheDir())
        Log.i(TAG, "externalCacheDir:" + getExternalCacheDir("hello"))


        Log.i(TAG, "publicDownloadDir:" + getPublicDownloadDir())

        Log.i(TAG, "isMountSdcard:" + isMountSdcard())

        val fis = FileInputStream("/sdcard/a.jpeg")
        closeQuietly(fis)

        mkdirs("/sdcard/sloop/test")

    }
}
