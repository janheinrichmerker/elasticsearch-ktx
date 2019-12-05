import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
    `maven-publish`
    id("org.jetbrains.dokka") version "0.9.17"
}

group = "dev.reimer"
version = "0.1.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")
    compileOnly("org.elasticsearch.client:elasticsearch-rest-high-level-client:7.5.0")
}

// Compile Kotlin to JVM1.8 bytecode.
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

// Include project license in generated JARs.
tasks.withType<Jar> {
    from(project.projectDir) {
        include("LICENSE")
        into("META-INF")
    }
}

// Generate Kotlin/Java documentation from sources.
tasks.dokka {
    outputFormat = "html"
}

// JAR containing Kotlin/Java documentation.
val javadoc = tasks.create<Jar>("javadocJar") {
    dependsOn(tasks.dokka)
    from(tasks.dokka.get().outputDirectory)
}

// JAR containing all source files.
val sources = tasks.create<Jar>("sourcesJar") {
    dependsOn("classes")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            artifact(sources) {
                classifier = "sources"
            }

            artifact(javadoc) {
                classifier = "javadoc"
            }
        }
    }
}
