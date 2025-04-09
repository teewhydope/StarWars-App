# Starwarz-App-KMM

A Kotlin Multiplatform Mobile Project that demonstrates code sharing between iOS and Android apps.

This project was built using Android Studio Meerkat | 2024.3.1 Patch 1.

### Features

- Clean Architecture
- MVVM
- [Shared Business Logic](https://github.com/teewhydope/JoyFin-KMM/tree/main/common)
- Native
  UI ([Android XML](https://github.com/teewhydope/JoyFin-KMM/tree/main/app-ui/src/main/java/com/teewhydope/app)
  and [SwiftUi](https://github.com/teewhydope/JoyFin-KMM/tree/main/iosApp/iosApp/ViewController))
- Shared Viewmodel
- Koin Di

## Building iOS Data

1. run build from the terminal to generate ios framework

```
> ./gradlew common:ios-data:build 
```
