plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.devjj.platform.nurbanhoney.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        resources {
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
}
dependencies {
//    implementation(kotlin("stdlib-jdk8"))

    implementation(project(":Domain"))
    implementation(project(":ErrorHandler"))

    // dagger
    val hilt = rootProject.extra["hilt_version"] as String
    implementation("com.google.dagger:hilt-android:$hilt")
    kapt("com.google.dagger:hilt-android-compiler:$hilt")
    androidTestImplementation("com.google.dagger:hilt-android-testing:$hilt")
    kaptAndroidTest("com.google.dagger:hilt-android-testing-compiler:$hilt")
    implementation("androidx.core:core-ktx:1.9.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")




    val retrofit = rootProject.extra["retrofit_version"] as String
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    implementation("com.jakewharton.threetenabp:threetenabp:1.3.0")
}
