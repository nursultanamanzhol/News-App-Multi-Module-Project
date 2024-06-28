import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "kz.jetpack.news_presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(":common:common_utils"))
    implementation(project(":news:news_domain"))

    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.androidMaterial)
    implementation(Deps.constraintLayout)
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)

    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltCompiler)
    kapt(DaggerHilt.hiltAndroidCompiler)

    implementation(Coroutines.coroutineCore)
    implementation(Coroutines.coroutineAndroid)
    implementation(CoroutinesLifecycleScope.lifeCycleRuntime)
    implementation(CoroutinesLifecycleScope.lifecycleViewModel)

    implementation(Glide.glide)
    kapt(Glide.annotationProcessor)

    implementation(ViewModelDelegate.viewModelDeligate)
    implementation(CircularProgressBar.swipeRefresh)
}