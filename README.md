![Image](/img/github_banner.png)

### Specs
[ ![Download](https://api.bintray.com/packages/nisrulz/maven/com.github.nisrulz%3Ascreenshott/images/download.svg) ](https://bintray.com/nisrulz/maven/com.github.nisrulz%3Ascreenshott/_latestVersion) [![API](https://img.shields.io/badge/API-14%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=14)

### Badges/Featured In
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Screenshott-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/4963#) [![AndroidDev Digest](https://img.shields.io/badge/AndroidDev%20Digest-%23125-blue.svg)](https://www.androiddevdigest.com/digest-125/)

### Show some :heart: and star the repo to support the project
[![GitHub stars](https://img.shields.io/github/stars/nisrulz/screenshott.svg?style=social&label=Star)](https://github.com/nisrulz/screenshott) [![GitHub forks](https://img.shields.io/github/forks/nisrulz/screenshott.svg?style=social&label=Fork)](https://github.com/nisrulz/screenshott/fork) [![GitHub watchers](https://img.shields.io/github/watchers/nisrulz/screenshott.svg?style=social&label=Watch)](https://github.com/nisrulz/screenshott) [![GitHub followers](https://img.shields.io/github/followers/nisrulz.svg?style=social&label=Follow)](https://github.com/nisrulz)
[![Twitter Follow](https://img.shields.io/twitter/follow/nisrulz.svg?style=social)](https://twitter.com/nisrulz)


Take a screenshot of your view layout , programmatically!

![sc1](/img/sc1.png)  ![sc2](/img/sc2.png)

# Including in your project
ScreenShott is available in the Jcenter, so getting it as simple as adding it as a dependency
```gradle
compile 'com.github.nisrulz:screenshott:{latest version}'
```
where `{latest version}` corresponds to published version in [ ![Download](https://api.bintray.com/packages/nisrulz/maven/com.github.nisrulz%3Ascreenshott/images/download.svg) ](https://bintray.com/nisrulz/maven/com.github.nisrulz%3Ascreenshott/_latestVersion)


# Usage
+ Get bitmap of screenshot

  ```java
  // View with spaces as per constraints
  Bitmap bitmap_view = ScreenShott.getInstance().takeScreenShotOfView(view);

  // RootView
  Bitmap bitmap_rootview = ScreenShott.getInstance().takeScreenShotOfRootView(view);

  // Just the View without any constraints
  Bitmap bitmap_hiddenview = ScreenShott.getInstance().takeScreenShotOfJustView(view);

  // Texture View
  Bitmap bitmap_textureview= ScreenShott.getInstance().takeScreenShotOfTextureView(textureview);
  ```

+ Save the bitmap using the provided helper function

  ```java
  File file = ScreenShott.getInstance().saveScreenshotToPicturesFolder(context, bitmap, "my_screenshot_filename");
  ```
  You can use the `file` object returned by `saveScreenshotToPicturesFolder()` to get the file object and then the path of the file saved

  ```java
  String bitmapFilePath = file.getAbsolutePath();
  ```
  > Add permission `<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>` to your AndroidManifest.xml
  >
  > Request the runtime permission for `android.permission.WRITE_EXTERNAL_STORAGE` to allow saving the file to external storage.

  .. or save the bitmap with your own implementation


### Pull Requests
I welcome and encourage all pull requests. It usually will take me within 24-48 hours to respond to any issue or request. Here are some basic rules to follow to ensure timely addition of your request:
  1. Match coding style (braces, spacing, etc.) This is best achieved using `CMD`+`Option`+`L` (Reformat code) on Mac (not sure for Windows) with Android Studio defaults.
  2. If its a feature, bugfix, or anything please only change code to what you specify.
  3. Please keep PR titles easy to read and descriptive of changes, this will make them easier to merge :)
  4. Pull requests _must_ be made against `develop` branch. Any other branch (unless specified by the maintainers) will get rejected.
  5. Check for existing [issues](https://github.com/nisrulz/screenshott/issues) first, before filing an issue.
  6. Have fun!

### Created & Maintained By
[Nishant Srivastava](https://github.com/nisrulz) ([@nisrulz](https://www.twitter.com/nisrulz))


> If you found this library helpful or you learned something from the source code and want to thank me, consider buying me a cup of :coffee:
>  + [PayPal](https://www.paypal.me/nisrulz/5)
>  + Bitcoin Address: 13PjuJcfVW2Ad81fawqwLtku4bZLv1AxCL

License
=======

    Copyright 2016 Nishant Srivastava

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.