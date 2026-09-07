plugins {
 id("com.android.application");id("org.jetbrains.kotlin.android");id("org.jetbrains.kotlin.plugin.compose");id("org.jetbrains.kotlin.plugin.serialization");id("com.google.devtools.ksp")
}
android {
 namespace="com.github.amateurishprogrammer.electronicsknowledge";compileSdk=36
 defaultConfig { applicationId="com.github.amateurishprogrammer.electronicsknowledge";minSdk=26;targetSdk=36;versionCode=1;versionName="0.1.0";testInstrumentationRunner="androidx.test.runner.AndroidJUnitRunner" }
 signingConfigs { create("release") { val p=System.getenv("ANDROID_KEYSTORE_PATH");if(p!=null){storeFile=file(p);storePassword=System.getenv("ANDROID_KEYSTORE_PASSWORD");keyAlias=System.getenv("ANDROID_KEY_ALIAS");keyPassword=System.getenv("ANDROID_KEY_PASSWORD")} } }
 buildTypes { release { isMinifyEnabled=true;if(System.getenv("ANDROID_KEYSTORE_PATH")!=null)signingConfig=signingConfigs.getByName("release");proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro") } }
 buildFeatures { compose=true;buildConfig=true };packaging { resources.excludes += "/META-INF/{AL2.0,LGPL2.1}" }
 compileOptions { sourceCompatibility=JavaVersion.VERSION_17;targetCompatibility=JavaVersion.VERSION_17 };kotlinOptions { jvmTarget="17" }
}
dependencies {
 implementation(platform("androidx.compose:compose-bom:2025.06.00"));androidTestImplementation(platform("androidx.compose:compose-bom:2025.06.00"))
 implementation("androidx.activity:activity-compose:1.10.1");implementation("androidx.compose.material3:material3");implementation("androidx.compose.material:material-icons-extended");implementation("androidx.compose.ui:ui-tooling-preview");debugImplementation("androidx.compose.ui:ui-tooling")
 implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.1");implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.1");implementation("androidx.navigation:navigation-compose:2.9.0")
 implementation("androidx.room:room-runtime:2.7.2");implementation("androidx.room:room-ktx:2.7.2");ksp("androidx.room:room-compiler:2.7.2")
 implementation("androidx.datastore:datastore-preferences:1.1.7");implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1");implementation("io.coil-kt.coil3:coil-compose:3.2.0");implementation("io.coil-kt.coil3:coil-svg:3.2.0")
 testImplementation("junit:junit:4.13.2");testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2");androidTestImplementation("androidx.test.ext:junit:1.2.1");androidTestImplementation("androidx.compose.ui:ui-test-junit4");debugImplementation("androidx.compose.ui:ui-test-manifest")
}
