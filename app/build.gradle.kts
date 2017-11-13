import com.github.gfx.ribbonizer.FilterBuilder
import com.github.gfx.ribbonizer.GrayRibbonBuilder
import com.github.gfx.ribbonizer.YellowRibbonBuilder

plugins {
    id("com.android.application") version "3.0.0"
    kotlin("android") version "1.2.0-rc-39"
    kotlin("android.extensions") version "1.2.0-rc-39"
    id("com.github.gfx.ribbonizer") version "2.1.0"
    id("com.google.gms.google-services") version "3.1.2" apply false
}

android {
    compileSdkVersion(26)
    defaultConfig {
        applicationId = "com.chibatching.ktssample"
        minSdkVersion(17)
        targetSdkVersion(26)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), file("proguard-rules.pro"))
        }
    }
}

ribbonizer {
    withGroovyBuilder {
        "builder"(FilterBuilder { variant, iconFile ->
            return@FilterBuilder when (variant.buildType.name) {
                "debug" -> YellowRibbonBuilder().apply(variant, iconFile)
                else -> GrayRibbonBuilder().apply(variant, iconFile)
            }
        })
    }
}

val kotlinVersion: String by extra

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to arrayOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlinVersion")

    implementation("com.android.support:appcompat-v7:26.1.0")
    implementation("com.android.support.constraint:constraint-layout:1.0.2")

    implementation("com.google.firebase:firebase-core:11.6.0")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.1")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.1")
}

apply(mapOf("plugin" to "com.google.gms.google-services"))
