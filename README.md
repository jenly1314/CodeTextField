# CodeTextField

[![Download](https://img.shields.io/badge/download-App-blue.svg)](https://raw.githubusercontent.com/jenly1314/CodeTextField/master/app/release/app-release.apk)
[![MavenCentral](https://img.shields.io/maven-central/v/com.github.jenly1314/codetextfield)](https://repo1.maven.org/maven2/com/github/jenly1314/codetextfield)
[![JitPack](https://jitpack.io/v/jenly1314/CodeTextField.svg)](https://jitpack.io/#jenly1314/CodeTextField)
[![CircleCI](https://circleci.com/gh/jenly1314/CodeTextField.svg?style=svg)](https://circleci.com/gh/jenly1314/CodeTextField)
[![API](https://img.shields.io/badge/API-21%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/mit-license.php)
[![Blog](https://img.shields.io/badge/blog-Jenly-9933CC.svg)](https://jenly1314.github.io/)
[![QQGroup](https://img.shields.io/badge/QQGroup-20867961-blue.svg)](http://shang.qq.com/wpa/qunwpa?idkey=8fcc6a2f88552ea44b1411582c94fd124f7bb3ec227e2a400dbbfaad3dc2f5ad)

CodeTextField for Jetpack Compose；一个使用 Compose 实现的验证码输入框。

> 原生 **Android自定义View** 实现的可参见 [SplitEditText](https://github.com/jenly1314/SplitEditText)

## Gif 展示
![Image](GIF.gif)


## 引入

### Gradle:

1. 在Project的 **build.gradle** 里面添加远程仓库

```gradle
allprojects {
    repositories {
        //...
        mavenCentral()
    }
}
```

2. 在Module的 **build.gradle** 里面添加引入依赖项

```gradle
implementation 'com.github.jenly1314:codetextfield:1.0.0'
```

## 示例

### 代码示例

```kotlin
    val text = remember {
        mutableStateOf("")
    }
    // 验证码输入框
    CodeTextField(value = text.value, onValueChange = {
        text.value = it
    })

```

更多使用详情，请查看[app](app)中的源码使用示例

## 相关推荐

#### [SplitEditText](https://github.com/jenly1314/SplitEditText) 一个灵活的分割可编辑框；常常应用于 **验证码输入** 、**密码输入** 等场景。

#### [KingKeyboard](https://github.com/jenly1314/KingKeyboard) 自定义键盘，满足各种不同场景的键盘输入需求

## 版本记录


#### v1.0.0：2022-11-20
*  CodeTextField初始版本

## 赞赏
如果您喜欢CodeTextField，或感觉CodeTextField帮助到了您，可以点右上角“Star”支持一下，您的支持就是我的动力，谢谢 :smiley:<p>
您也可以扫描下方的二维码，请作者喝杯咖啡 :coffee:
<div>
<img src="https://jenly1314.github.io/image/pay/sponsor.png">
</div>

## 关于我
Name: <a title="关于作者" href="https://jenly1314.github.io" target="_blank">Jenly</a>

Email: <a title="欢迎邮件与我交流" href="mailto:jenly1314@gmail.com" target="_blank">jenly1314#gmail.com</a> / <a title="给我发邮件" href="mailto:jenly1314@vip.qq.com" target="_blank">jenly1314#vip.qq.com</a>

CSDN: <a title="CSDN博客" href="http://blog.csdn.net/jenly121" target="_blank">jenly121</a>

CNBlogs: <a title="博客园" href="https://www.cnblogs.com/jenly" target="_blank">jenly</a>

GitHub: <a title="GitHub开源项目" href="https://github.com/jenly1314" target="_blank">jenly1314</a>

Gitee: <a title="Gitee开源项目" href="https://gitee.com/jenly1314" target="_blank">jenly1314</a>

加入QQ群: <a title="点击加入QQ群" href="http://shang.qq.com/wpa/qunwpa?idkey=8fcc6a2f88552ea44b1411582c94fd124f7bb3ec227e2a400dbbfaad3dc2f5ad" target="_blank">20867961</a>
   <div>
       <img src="https://jenly1314.github.io/image/jenly666.png">
       <img src="https://jenly1314.github.io/image/qqgourp.png">
   </div>