import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.devjj.platform.nerbanhoney.di"
    compileSdk = 33

    defaultConfig {
        minSdk = 23
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
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //dagger
    implementation("com.google.dagger:hilt-android:2.44.1")
    //dagger compiler
    kapt("com.google.dagger:hilt-android-compiler:2.44.1")
    //dagger hilt compiler
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    //dagger hilt android
    implementation("com.google.dagger:hilt-android:2.44.1")
    //dagger hilt android compiler
    kapt("com.google.dagger:hilt-android-compiler:2.44.1")
    //dagger hilt android testing
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.44.1")
    //dagger hilt android testing compiler
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.44.1")
    //dagger hilt android testing compiler
    kaptAndroidTest("com.google.dagger:hilt-android-testing-compiler:2.44.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.dagger:hilt-android:2.44.1")
    implementation("com.google.dagger:hilt-android-compiler:2.44.1")

}