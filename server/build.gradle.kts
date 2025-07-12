plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0-Beta1"
}

val exposed_version: String by project
val ktor_version: String by project
val postgresql_version: String by project

group = "in.hrup.orion"
version = "1.0.0"
application {
    mainClass.set("in.hrup.orion.ApplicationKt")
    
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    
    implementation(libs.logback)
    implementation(libs.ktor.serverCore)
    implementation(libs.ktor.serverNetty)
    testImplementation(libs.ktor.serverTestHost)
    testImplementation(libs.kotlin.testJunit)

    implementation("io.ktor:ktor-server-content-negotiation:${ktor_version}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${ktor_version}")
    implementation("io.ktor:ktor-server-sessions:${ktor_version}")
    implementation("io.ktor:ktor-server-auth:${ktor_version}")

    implementation("org.jetbrains.exposed:exposed-core:${exposed_version}")
    implementation("org.jetbrains.exposed:exposed-dao:${exposed_version}")
    implementation("org.jetbrains.exposed:exposed-jdbc:${exposed_version}")
    implementation("org.xerial:sqlite-jdbc:3.45.1.0")
    //implementation("org.postgresql:postgresql:${postgresql_version}")

    implementation("com.google.code.gson:gson:2.11.0")

    implementation("io.ktor:ktor-server-html-builder:${ktor_version}")

}