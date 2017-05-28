# kotlin-library

基于 Kotlin 的 Library，主要是一些通用工具包。

## 概览

| 名称        | 最新版本  | 简介           |
| --------- | ----- | ------------ |
| AppUtils  | 0.0.2 | 与应用相关的一些基础工具 |
| FileUtils | 0.0.1 | 与文件相关的一些基础工具 |



# 详述

## AppUtils

与应用相关的一些基础工具包，主要包括以下内容：

| 方法             | 简介                       |
| -------------- | ------------------------ |
| getVersionName | 获取应用版本名，支持获取其它应用的版本名     |
| getVersionCode | 获取应用版本号，支持获取其它应用的版本号     |
| isInstall      | 判断应用是否安装，参数为包名           |
| isInDebug      | 判断应用是否处于Debug状态，支持判断其它应用 |
| isTablet       | 判断当前设备是否是平板              |
| openActivity   | 打开一个新的Activity，支持传递数据    |

使用示例：

```kotlin
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
```

导入方式：

```groovy
compile 'com.gcssloop.kotlin:apputils:0.0.2'
```



## FileUtils

与文件处理相关的一些工具集合。

| 方法                   | 简介                                       |
| -------------------- | ---------------------------------------- |
| getFileDir           | 获取应用文件目录("/data/data/<包名>/files")        |
| getCacheDir          | 获取应用缓存目录("/data/data/<包名>/cache")        |
| getExternalFileDir   | 获取应用程序文件目录("/sdcard/Android/data/<包名>/files") |
| getExternalCacheDir  | 获取应用程序缓存目录("/sdcard/Android/data/<包名>/cache") |
| getPublicDownloadDir | 获取公共下载文件夹                                |
| closeQuietly         | 关闭可以关闭的对象，一般用于各种流(Steam)                 |
| mkdirs               | 根据文件夹路径创建文件夹                             |
| isMountSdcard        | 判断内存卡是否挂载                                |

使用示例：

```kotlin
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
```

导入方式：

```groovy
compile 'com.gcssloop.kotlin:fileutils:0.0.1'
```



## 导入仓库注意事项

由于我没有将代码发布到公共仓库中，所以如果需要引用我的仓库，需要在你的项目根 `build.gradle` 中添加上这样一行代码：

```groovy
allprojects {
    repositories {
        jcenter()
        // 就是下面这一行
        maven { url "http://library.gcssloop.com:8081/repository/gcs-repository/" }
    }
}
```

之后在你需要引用我的项目的 Module 下添加 `compile '<包名>:<项目名>:<版本号>'` 才会起效，除了需要在项目根 `build.gradle` 添加我的仓库地址外，其余的使用方式和使用中央仓库的方式是完全一致的。 

当然，你也可以到我的 [私人仓库](http://library.gcssloop.com:8081/#browse/browse/components:gcs-repository) 中查看我都发布了哪些内容，后续我会将之前的一些Java项目从我的本地仓库迁移到这个仓库中。