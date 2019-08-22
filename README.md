# android-domain-notifications

[![Build Status](https://dev.azure.com/psmorandi/Android%20Domain%20Notifications/_apis/build/status/psmorandi.android-domain-notifications?branchName=master)](https://dev.azure.com/psmorandi/Android%20Domain%20Notifications/_build/latest?definitionId=1&branchName=master) [ ![Download](https://api.bintray.com/packages/psmorandi/android-domain-notifications/com.psmorandi.android.notifications/images/download.svg) ](https://bintray.com/psmorandi/android-domain-notifications/com.psmorandi.android.notifications/_latestVersion)

About
-----

Implementation of notification pattern, where an object collects all information about errors in the domain layer and communicate it to the presentation layer. Based on the great work by @andrebaltieri: https://github.com/andrebaltieri/flunt.

Usage
-----

Configure your `build.gradle` to access JCenter:

```
repositories {
    jcenter()
}
```

Then add the dependency:

```
dependencies {    
    implementation 'com.psmorandi:domain-notifications:1.0.7'
}
```

Please check unit tests for example on how to use this library.
