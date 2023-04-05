plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.devjj.platform.nurbanhoney"
        minSdk = 26
        targetSdk = compileSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
    namespace = "com.devjj.platform.nurbanhoney"
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation(project(":ErrorHandler"))
    implementation(project(":DI"))
    implementation(project(":Domain"))

    // lifeCycle
    val lifecycle = rootProject.extra["lifecycle_version"] as String
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle")

    // compose
    val composeBom = platform("androidx.compose:compose-bom:2023.03.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui")
    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.compiler:compiler:1.4.4")
    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.compose.material:material-icons-extended")

    // Optional - Integration with activities
    implementation("androidx.activity:activity-compose:1.7.0")
    // Optional - Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle")
    // Optional - Integration with LiveData
    implementation("androidx.compose.runtime:runtime-livedata")
    // Optional - Integration with RxJava
//    implementation("androidx.compose.runtime:runtime-rxjava2")
//    implementation("androidx.activity:activity:1.6.1")

    // dagger-hilt
    val hilt = rootProject.extra["hilt_version"] as String
    implementation("com.google.dagger:hilt-android:$hilt")
    kapt("com.google.dagger:hilt-android-compiler:$hilt")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle")

    implementation("androidx.core:core-splashscreen:1.0.0")
    implementation("com.airbnb.android:lottie-compose:6.0.0")
    implementation("androidx.navigation:navigation-compose:2.5.3")
// hilt navigation
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")

    // okhttp
    // define a BOM and its version
    val okhttpBom = platform("com.squareup.okhttp3:okhttp-bom:4.10.0")
    implementation(okhttpBom)

    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")
    implementation("com.squareup.okhttp3:okhttp-urlconnection")

    // retrofit
    val retrofit = rootProject.extra["retrofit_version"] as String
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    // coil
    implementation("io.coil-kt:coil-compose:2.3.0")

    val orbit = rootProject.extra["orbit_version"] as String
    implementation("org.orbit-mvi:orbit-core:$orbit")
// or, if on Android:
    implementation("org.orbit-mvi:orbit-viewmodel:$orbit")
// If using Jetpack Compose include
    implementation("org.orbit-mvi:orbit-compose:$orbit")

// Tests
    testImplementation("org.orbit-mvi:orbit-test:$orbit")
}

kapt {
    correctErrorTypes = true
}
