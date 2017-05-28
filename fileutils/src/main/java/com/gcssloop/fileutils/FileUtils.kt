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
 * Last modified 2017-05-28 20:25:52
 *
 * GitHub: https://github.com/GcsSloop
 * WeiBo: http://weibo.com/GcsSloop
 * WebSite: http://www.gcssloop.com
 */

package com.gcssloop.fileutils

import android.content.Context
import android.os.Environment
import java.io.Closeable
import java.io.File


/**
 * 获取应用文件目录
 * @param customPath 自定义路径
 * @return 应用程序文件目录("/data/data/<包名>/files")
 */
fun Context.getFileDir(customPath: String = ""): File {
    val file = File(this.filesDir.absolutePath + File.separator + customPath + File.separator)
    file.mkdirs()
    return file
}

/**
 * 获取应用缓存目录
 * @param customPath 自定义路径
 * @return 应用程序缓存目录("/data/data/<包名>/cache")
 */
fun Context.getCacheDir(customPath: String = ""): File {
    val file = File(this.cacheDir.absolutePath + File.separator + customPath + File.separator)
    file.mkdirs()
    return file
}


/**
 * 获取应用外置文件目录
 * @param customPath 自定义路径
 * @return 应用程序文件目录("/Android/data/<包名>/files")
 */
fun Context.getExternalFileDir(customPath: String = ""): File {
    val file = File(this.getExternalFilesDir("").absolutePath + File.separator + customPath + File.separator)
    file.mkdirs()
    return file
}

/**
 * 获取应用外置缓存目录
 * @param customPath 自定义路径
 * @return 应用程序缓存目录("/Android/data/<包名>/cache")
 */
fun Context.getExternalCacheDir(customPath: String = ""): File {
    val file = File(this.externalCacheDir.absolutePath + File.separator + customPath + File.separator)
    file.mkdirs()
    return file
}


/**
 * 获取公共下载文件夹
 * @return 公共下载文件夹
 */
fun getPublicDownloadDir(): String {
    return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            .absolutePath
}

/**
 * 关闭Closeable对象
 * @param closeable 可关闭的对象
 */
fun closeQuietly(closeable: Closeable?) {
    if (null != closeable) {
        try {
            closeable.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

/**
 * 创建文件夹
 * @param filePath 文件夹路径
 */
fun mkdirs(filePath: String) {
    val file = File(filePath)
    if (!(file.exists() and file.isDirectory)) {
        file.mkdirs()
    }
}

/**
 * 内存卡是否挂载
 * @return true 表示挂载，false 表示没有挂载
 */
fun isMountSdcard(): Boolean {
    val status = Environment.getExternalStorageState()
    return status == Environment.MEDIA_MOUNTED
}