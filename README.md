# ScreenShott

### Specs
[ ![Download](https://api.bintray.com/packages/nisrulz/maven/com.github.nisrulz%3Ascreenshott/images/download.svg) ](https://bintray.com/nisrulz/maven/com.github.nisrulz%3Ascreenshott/_latestVersion)

### Show some :heart:
[![GitHub stars](https://img.shields.io/github/stars/nisrulz/screenshott.svg?style=social&label=Star)](https://github.com/nisrulz/screenshott) [![GitHub forks](https://img.shields.io/github/forks/nisrulz/screenshott.svg?style=social&label=Fork)](https://github.com/nisrulz/screenshott/fork) [![GitHub watchers](https://img.shields.io/github/watchers/nisrulz/screenshott.svg?style=social&label=Watch)](https://github.com/nisrulz/screenshott) [![GitHub followers](https://img.shields.io/github/followers/nisrulz.svg?style=social&label=Follow)](https://github.com/nisrulz)
[![Twitter Follow](https://img.shields.io/twitter/follow/nisrulz.svg?style=social)](https://twitter.com/nisrulz)


Take screenshot on a click of a button.

# Including in your project
ScreenShott is available in the Jcenter, so getting it as simple as adding it as a dependency
```gradle
compile 'com.github.nisrulz:screenshott:{latest version}'
```
where `{latest version}` corresponds to published version in [ ![Download](https://api.bintray.com/packages/nisrulz/maven/com.github.nisrulz%3Ascreenshott/images/download.svg) ](https://bintray.com/nisrulz/maven/com.github.nisrulz%3Ascreenshott/_latestVersion)


#Usage
+ Get bitmap of screenshot and save it on device

```java
ScreenShott.getInstance().takeScreenShotOfRootView(view);
```

where the param is _**view**_

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
