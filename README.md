# android-domain-notifications

[![Android CI](https://github.com/psmorandi/android-domain-notifications/actions/workflows/ci.yml/badge.svg)](https://github.com/psmorandi/android-domain-notifications/actions/workflows/ci.yml)

About
-----

Implementation of notification pattern, where an object collects all information about errors in the domain layer and communicate it to the presentation layer. Based on the great work by @andrebaltieri: https://github.com/andrebaltieri/flunt.

Usage
-----

Configure your `build.gradle` to access Maven Central:

```
repositories {
    mavenCentral()
}
```

Then add the dependency:

```
dependencies {    
    implementation 'io.github.com:domain-notifications:2.0.0'
}
```

Please check unit tests for example on how to use this library.
