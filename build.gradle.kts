plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    kotlin("plugin.serialization") version "2.1.20" apply false
    alias(libs.plugins.ksp).apply(false)
    alias(libs.plugins.compose.compiler) apply false
}

buildscript {
    dependencies {}
}
