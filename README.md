# CodeTextField

[![MavenCentral](https://img.shields.io/maven-central/v/com.github.jenly1314/codetextfield?logo=sonatype)](https://repo1.maven.org/maven2/com/github/jenly1314/CodeTextField)
[![JitPack](https://img.shields.io/jitpack/v/github/jenly1314/CodeTextField?logo=jitpack)](https://jitpack.io/#jenly1314/CodeTextField)
[![CI](https://img.shields.io/github/actions/workflow/status/jenly1314/CodeTextField/build.yml?logo=github)](https://github.com/jenly1314/CodeTextField/actions/workflows/build.yml)
[![Download](https://img.shields.io/badge/download-APK-brightgreen?logo=github)](https://raw.githubusercontent.com/jenly1314/CodeTextField/master/app/release/app-release.apk)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen?logo=android)](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)
[![License](https://img.shields.io/github/license/jenly1314/CodeTextField?logo=open-source-initiative)](https://opensource.org/licenses/mit)

CodeTextField for Jetpack Compose；一个使用 Compose 实现的验证码输入框。

> 原生Android View实现类似的输入框可参见 [SplitEditText](https://github.com/jenly1314/SplitEditText)

## 效果展示
![Image](GIF.gif)

> 你也可以直接下载 [演示App](https://raw.githubusercontent.com/jenly1314/CodeTextField/master/app/release/app-release.apk) 体验效果

## 引入

### Gradle:

1. 在Project的 **build.gradle** 或 **setting.gradle** 中添加远程仓库

    ```gradle
    repositories {
        //...
        mavenCentral()
    }
    ```

2. 在Module的 **build.gradle** 中添加依赖项

    ```gradle
    implementation 'com.github.jenly1314:codetextfield:1.0.0'
    ```

## 使用

### 代码示例

```kotlin
    var text by remember {
        mutableStateOf("")
    }
    // 验证码输入框
    CodeTextField(value = text, onValueChange = {
        text = it
    })

```

更多使用详情，请查看[app](app)中的源码使用示例或直接查看 [API帮助文档](https://jenly1314.github.io/CodeTextField/api/)

## 相关推荐

- [SplitEditText](https://github.com/jenly1314/SplitEditText) 一个灵活的分割可编辑框；常常应用于 **验证码输入** 、**密码输入** 等场景。
- [KingKeyboard](https://github.com/jenly1314/KingKeyboard) 一个自定义键盘，满足各种不同场景的键盘输入需求。
- [compose-component](https://github.com/jenly1314/compose-component) 一个Jetpack Compose的组件库；主要提供了一些小组件，便于快速使用。

<!-- end -->

## 版本日志

#### v1.0.0：2022-11-20
*  CodeTextField初始版本

---

![footer](https://jenly1314.github.io/page/footer.svg)
