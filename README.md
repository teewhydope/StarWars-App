# Starwarz-App-KMM

A Kotlin Multiplatform Mobile Project that demonstrates code sharing between iOS and Android apps.

### Features

- Clean Architecture
- MVVM
- [Shared Business Logic](https://github.com/teewhydope/StarWars-App/tree/main/common)
- Native
  UI ([Jetpack Compose](https://github.com/teewhydope/StarWars-App/tree/main/androidApp/src/main/java/com/teewhydope/app/ui)
  and [SwiftUi](https://github.com/teewhydope/StarWars-App/tree/main/iosApp/iosApp))
- [Shared Viewmodel](https://github.com/teewhydope/StarWars-App/tree/main/common/presentation/src/commonMain/kotlin/com/teewhydope/app/presentation)
- Koin Di
- SKIE

## Building iOS Data

1. This project was built using Android Studio Meerkat | Version 2024.3.1 Patch 1..

2. Run this Gradle build command from the terminal to generate the iOS framework.

```
> ./gradlew common:ios-data:build 
```
