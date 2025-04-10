plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("co.touchlab.skie") version "0.10.2-preview.2.1.20"

}

skie {
    features {
        enableSwiftUIObservingPreview = true
    }
}


kotlin {

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "CommonData"
            isStatic = true

            export(project(":common:logger"))
            export(project(":common:data"))
            export(project(":common:domain"))
            export(project(":common:presentation"))
            export(project(":common:di"))
        }
    }

    sourceSets {
        commonMain.dependencies {
        }

        iosMain.dependencies {
            api(project(":common:logger"))
            api(project(":common:data"))
            api(project(":common:domain"))
            api(project(":common:presentation"))
            api(project(":common:di"))
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }

    task("testClasses").doLast {
        //workaround for failing build
    }
}



