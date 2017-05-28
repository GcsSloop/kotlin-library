/*
 * Copyright 2017 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2017-05-26 10:52:35
 *
 * GitHub: https://github.com/GcsSloop
 * WeiBo: http://weibo.com/GcsSloop
 * WebSite: http://www.gcssloop.com
 */

package com.gcssloop.apputils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import org.jetbrains.annotations.NotNull
import java.io.Serializable


val TAG = "GcsAppUtils"
/**
 * 获取应用的版本名称, 如果返回为空说明获取失败
 * @param pkgName 包名，如果不传则默认获取当前应用的
 */
fun Context.getVersionName(pkgName: String = this.packageName): String {
    var versionName: String = ""
    try {
        versionName = this.packageManager.getPackageInfo(pkgName, 0).versionName
    } catch (e: Exception) {
        Log.e(TAG, "Exception", e)
    }
    return versionName
}

/**
 * 获取应用的版本名称，如果结果为 -1，则说明获取失败
 * @param pkgName 包名，如果不传则默认获取当前应用的
 */
fun Context.getVersionCode(pkgName: String = this.packageName): Int {
    var versionCode = -1
    try {
        versionCode = this.packageManager.getPackageInfo(pkgName, 0).versionCode
    } catch (e: PackageManager.NameNotFoundException) {
        Log.e(TAG, "Exception", e)
    }
    return versionCode
}

/**
 * 判断某个应用是否已经安装
 * @param pkgName 包名
 */
fun Context.isInstall(pkgName: String): Boolean {
    val pInfo = this.packageManager.getInstalledPackages(0)   //获取所有已安装程序的包信息
    return pInfo!!.indices.map { pInfo[it].packageName }.contains(pkgName)
}

/**
 * 判断应用是否处于 Debug 状态
 * @param pkgName 包名，如果不传则默认获取当前应用的
 */
fun Context.isInDebug(pkgName: String = this.packageName): Boolean {
    try {
        val pkginfo = this.packageManager.getPackageInfo(
                pkgName, PackageManager.GET_ACTIVITIES)
        return pkginfo!!.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    } catch (e: Exception) {
        Log.e(TAG, "Exception", e)
    }
    return false
}

/**
 * 是否是平板设备
 * @return true 是， false 不是
 */
fun Context.isTablet(): Boolean {
    return this.resources.configuration.screenLayout and Configuration
            .SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
}

/**
 * 打开新的 Activity
 * @param clazz Activity 的 class
 */
fun Context.startActivity(@NotNull clazz: Class<Activity>) {
    val intent: Intent = Intent(this, clazz)
    this.startActivity(intent)
}

/**
 * 打开新的 Activity
 * @param clazz Activity 的 class
 * @param datas 数据
 */
fun Context.startActivity(@NotNull clazz: Class<Activity>, @NotNull datas: Map<String, Serializable>) {
    val intent: Intent = Intent(this, clazz)
    for ((key, value) in datas) {
        intent.putExtra(key, value)
    }
    this.startActivity(intent)
}

/**
 * 打开新的 Activity
 * @param clazz Activity 的 class
 * @param key  key
 * @param data Bundle 数据
 */
fun Context.startActivity(@NotNull clazz: Class<Activity>, @NotNull key: String, @NotNull data: Bundle) {
    val intent: Intent = Intent(this, clazz)
    intent.putExtra(key, data)
    this.startActivity(intent)
}