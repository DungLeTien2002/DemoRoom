plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.demoroom"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.demoroom"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    packagingOptions {
        exclude("META-INF/atomicfu.kotlin_module")
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation ("com.google.android.material:material:1.5.0")

    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.activity:activity-ktx:1.4.0")

    // Dependencies for working with Architecture components
    // You'll probably have to update the version numbers in build.gradle (Project)

    // Room components
    implementation("androidx.room:room-ktx:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")
    androidTestImplementation("androidx.room:room-testing:2.5.0")

    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.4.0")

    // Kotlin components
    val kotlinVersion = rootProject.extra.get("kotlin_version") as String
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.31")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    // UI
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("com.google.android.material:material:1.4.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0") {
        exclude(group = "com.android.support", module = "support-annotations")
    }
    androidTestImplementation ("androidx.test.ext:junit:4.13.2")
}