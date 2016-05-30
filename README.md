由于受够了开发各式各样的Dialog,以后会根据遇到的产品情况慢慢完善这个类库

## FinalDialog（Android Dialog 终结者）
- an android library for dialog which has popular style on market!
- Min sdk on support is 15(Android 4.0.3)

### Demo

[Download](https://codeload.github.com/yuchao-wang/FinalDialog/zip/master)

![pic is here](https://github.com/yuchao-wang/FinalDialog/blob/master/image/screenshot.gif)

### Character
- 常用，简洁，美观
- 清晰的链式结构
- 处理Dialog容易被抛出WeakReference的问题
- 丰富的自定义选项

### Update
#### 1.0.0 (2016/05/30)

- ConfirmDialog
- MenuDialog
- NormalDialog
- ProgressDialog
- ToastDialog

### Dependence 

```
compile 'wang.yuchao.android.library.view.dialog:FinalDialogLibrary:1.0.0'
```

### Proguard

```
-keep class wang.yuchao.android.library.** { *; }
-dontwarn wang.yuchao.android.library.**


### [About Me](http://yuchao.wang)


### License

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```