## 1. Publishing the App.
### 1.1. Generate .apk
* increment version:
    * app/build.grade
        * versionCode 7
        * versionName "7"
    * README.md
* Android Studio > Build > Generate Signed Bundle / APK > APK
    * using 'keystore.jks' file (after decrypted keystore)
    * key alias: upload
    * Build Type: release
    * Signature Versions: V1 & V2
* app/release/app-release.apk

### 1.2. Upload .apk to Google Play Console
* [Google Play console](https://play.google.com/apps/publish)
    * Release management > App releases > Internal test track 
        * Manage > Create Release
            * Upload .apk
* [Privacy Policy](https://jameshnsears.github.io/brexitsoundboard/privacy_policy.html)

### 1.3. Amazon Appstore
* [Amazon Appstore](https://developer.amazon.com/apps-and-games)

## 2. Monitoring the release
* [Firebase Test Lab](https://console.firebase.google.com/project/brexit-soundboard/overview)
    * [Google Cloud Platform](https://console.cloud.google.com/home/dashboard)

## 3. Content Creation Tools 
### 3.1.Sounds
* [Audacity](https://www.audacityteam.org/) - cut clip from sound file.
* [Kazam](https://launchpad.net/kazam) - screen capture from browser.
* [VLC](https://www.videolan.org/) - extract sound from screen capture.

### 3.2. Images
* [GIMP](https://www.gimp.org/)
* [INKSCAPE](https://inkscape.org/)

## 4. Misc. Key management
### 4.1. Keystore
* keytool -genkeypair -alias upload -keyalg RSA -keysize 2048 -validity 9125 -keystore keystore.jks
### 4.1. Public
* keytool -export -rfc -alias upload -file upload_certificate.pem -keystore keystore.jks
