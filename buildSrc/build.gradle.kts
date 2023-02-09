plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
    kotlin("jvm") version "1.3.50" apply false
}
repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

subprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    group = "org.devjj.platform.nurbanhoney"
    version = "0.0.1"

    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }
    val implementation by configurations

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.google.dagger:hilt-android:2.44.1")
        //dagger dependencies
        implementation("com.google.dagger:hilt-android-compiler:2.44.1")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
        implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
        implementation("com.squareup.okhttp3:okhttp:4.9.1")
        implementation("com.squareup.okhttp3:okhttp-urlconnection:4.9.1")
        implementation("com.squareup.okhttp3:okhttp-tls:4.9.1")
        implementation("com.squareup.okhttp3:okhttp-ws:4.9.1")
        implementation("com.squareup.okhttp3:okhttp-dnsoverhttps:4.9.1")
        implementation("com.squareup.okhttp3:okhttp-sse:4.9.1")
        implementation("com.squareup.okhttp3:okhttp-mockwebserver:4.9.1")

    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}