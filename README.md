# ![image](https://raw.githubusercontent.com/Airsaid/AndroidLocalizePlugin/85cf5020832523ea333ad09286af55880460457a/src/main/resources/META-INF/pluginIcon.svg) AndroidLocalizePlugin
[![Plugin Version](https://img.shields.io/jetbrains/plugin/v/11174)](https://plugins.jetbrains.com/plugin/11174-androidlocalize)
[![Plugin Rating](https://img.shields.io/jetbrains/plugin/r/rating/11174)](https://plugins.jetbrains.com/plugin/11174-androidlocalize)

:earth_asia: Android/IDEA localization plugin. supports multiple languages and multiple translators. ([中文文档](https://github.com/Airsaid/AndroidLocalizePlugin/blob/master/README_CN.md))

# Features
- Multiple translator support:
  - Google translator. 
  - Microsoft translator.
  - Baidu translator.
  - Youdao translator.
- Supports up to 100+ languages.
- One key generates all translation files.
- Support no translation of existing string.
- Support for specifying that text is not translated.
- Support for caching translated strings. 
- Support to set the translation interval time.

# Preview
![image](https://github.com/Airsaid/AndroidLocalizePlugin/blob/master/preview/preview.gif)
![image](https://github.com/Airsaid/AndroidLocalizePlugin/blob/master/preview/settings.png)

# Install
[![Install Plugin](https://github.com/Airsaid/AndroidLocalizePlugin/blob/master/preview/install.png)](https://plugins.jetbrains.com/plugin/11174-androidlocalize)

# Usage
- Step 1: Select the values/strings.xml.
- Step 2: Right click and select "Translate to Other Languages".
- Step 3: Select the languages to be translated.
- Step 4: Click OK.

# FAQ
- Q: How to ignore translation?

    A: Use the [translatable or xliff:g](https://developer.android.com/guide/topics/resources/localization#managing-strings) tags. for example:
    ```
    <string name="app_name" translatable="false">HelloAndroid</string>
    <string name="star_rating">Check out our 5<xliff:g id="star">\u2605</xliff:g></string>
    <string name="app_home_url">Visit us at <xliff:g id="application_homepage">https://github.com/Airsaid/AndroidLocalizePlugin</xliff:g></string>
    <string name="prod_name">Learn more at <xliff:g id="game_group">Muggle Game Studio</xliff:g></string>
    ```
    **Note: Display one line without extra line breaks and spaces in between.**

# ChangeLog
[Change Log List](https://github.com/Airsaid/AndroidLocalizePlugin/blob/master/CHANGELOG.md)

# ContactMe
- Telegram: [https://t.me/airsaids/](https://t.me/airsaids/)

# Sponsors
[![Development powered by JetBrains](https://pic.stackoverflow.wiki/uploadImages/111/201/226/60/2021/06/20/18/45/3aba65f5-1231-4c9a-817f-83cd5a29fd0c.svg)](https://jb.gg/OpenSourc)

# License
```
Copyright 2018 Airsaid. https://github.com/airsaid

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