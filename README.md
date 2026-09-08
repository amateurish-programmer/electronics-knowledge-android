# 电子专业知识库

离线优先的 Android 电子元器件手册，采用 Kotlin、Jetpack Compose、Room 和 DataStore。

## 当前能力

- 100 个常用元器件与经典型号条目
- 中文、英文、型号和别名搜索
- 分类、收藏、最近浏览、深浅色主题
- 内容和自绘 SVG 随 APK 离线提供
- Android 8.0（API 26）及以上

## 云端开发

在 GitHub 仓库点击 **Code → Codespaces → Create codespace**。开发容器会安装 JDK 17、Node 22、Gradle 8.13 和 Android SDK 36。

```bash
npm test
npm run content:validate
npm run content:compile
gradle test lint assembleDebug
```

Pull Request 自动执行相同验证并上传 Debug APK。推送 `v*` 标签后，Release 工作流使用以下 GitHub Secrets 构建签名 APK：

- `ANDROID_KEYSTORE_BASE64`
- `ANDROID_KEYSTORE_PASSWORD`
- `ANDROID_KEY_ALIAS`
- `ANDROID_KEY_PASSWORD`

## 内容维护

每个条目位于 `content/entries`，使用带元数据的 Markdown。图片位于 `content/assets/images`，校验器会检查数量、唯一 ID、必填章节、图片许可和资料来源。

## 许可

代码拟采用 Apache-2.0；原创文字和自绘 SVG 拟采用 CC BY 4.0。仓库公开前需完成最终许可文本和第三方来源审计。
