buildscript {
    val compose_version by extra("1.4.0")
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.4.0" apply false
    id("com.android.library") version "7.4.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false

}

//configurations.all { resolutionStrategy { exclude group : "org.jetbrains.kotlinx", module: "kotlinx-coroutines-debug" } }
configurations.all() {
    resolutionStrategy {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-debug")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}