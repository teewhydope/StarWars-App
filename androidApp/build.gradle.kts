plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinxSerialization)

}

android {
    namespace = "com.teewhydope.app.starwars.android"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.teewhydope.app.starwars.android"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
//    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    api(project("::common:presentation"))
    api(project("::common:di"))
    api(project("::common:logger"))

    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.material)
    implementation(libs.compose.material3)

    implementation(libs.koin.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.composeVM)
    implementation(libs.androidx.lifecycle.runtime.compose.android)

    implementation(libs.kotlinx.serialization.json)


    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.compose.navigation)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation("androidx.navigation:navigation-compose:2.7.0-rc01")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")

    implementation(libs.coil.compose)

    implementation(libs.rxkotlin)

}