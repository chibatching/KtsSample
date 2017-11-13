allprojects {
    val kotlinVersion by extra { "1.2.0-rc-39" }
    repositories {
        google()
        jcenter()
        maven(url = "http://dl.bintray.com/kotlin/kotlin-eap-1.2")
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
