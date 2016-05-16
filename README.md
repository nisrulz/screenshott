# ScreenShott    [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.nisrulz/screenshott/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.nisrulz/screenshott) [![Twitter](https://img.shields.io/badge/Twitter-@nisrulz-blue.svg?style=flat)](http://twitter.com/nisrulz)

Take screenshot on a click of a button.

#Integration
- ScreenShott is available in the MavenCentral, so getting it as simple as adding it as a dependency
```gradle
compile 'com.github.nisrulz:screenshott:1.0.0'
```

#Usage
+ Get bitmap of screenshot and save it on device
```java
    ScreenShott.getInstance().takeScreenShotOfRootView(view);
```

where the param is _**view**_

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
