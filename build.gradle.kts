import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
    `maven-publish`
}

group = "com.heinrichreimer"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")
//    compile("org.elasticsearch.client:transport:6.5.2")
    compile("org.elasticsearch.client:elasticsearch-rest-high-level-client:6.5.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}