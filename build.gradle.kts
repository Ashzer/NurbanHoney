buildscript {
    extra.apply {
        set("compose_version", "1.4.3")
        set("orbit_version", "4.6.1")
        set("retrofit_version", "2.9.0")
        set("lifecycle_version", "2.6.1")
        set("hilt_version", "2.45")
    }
} // Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.4.1" apply false
    id("com.android.library") version "7.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
    id("com.google.dagger.hilt.android") version "2.45" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.3.1"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
}

allprojects {
    apply {
        plugin("org.jlleitschuh.gradle.ktlint")
        plugin("io.gitlab.arturbosch.detekt")
    }
    afterEvaluate {
        detekt {
            buildUponDefaultConfig = true
            config.setFrom(files("$rootDir/detekt-config.yml"))
        }
    }
    ktlint {
        disabledRules.set(listOf("no-wildcard-imports"))
    }

    dependencies {
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")
    }
}

configurations.all() {
    resolutionStrategy {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-debug")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
