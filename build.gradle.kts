buildscript {
    val kotlinVersion by extra { "1.2.0-rc-39" }
    repositories {
        google()
        jcenter()
        maven(url = "http://dl.bintray.com/kotlin/kotlin-eap-1.2")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.google.gms:google-services:3.1.2")
        classpath("com.github.gfx.ribbonizer:ribbonizer-plugin:2.1.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "http://dl.bintray.com/kotlin/kotlin-eap-1.2")
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
