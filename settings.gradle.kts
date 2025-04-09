enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "StarWars"
include(":androidApp")
include(":common:logger")
include(":common:domain")
include(":common:data")
include(":common:ios-data")
include(":common:presentation")
include(":common:di")
