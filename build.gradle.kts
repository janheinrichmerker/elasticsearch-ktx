import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.0"
    `maven-publish`
    id("org.jetbrains.dokka") version "0.9.17"
    id("com.palantir.git-version") version "3.1.0"
}

val gitVersion: groovy.lang.Closure<String> by extra
group = "dev.reimer"
version = gitVersion()

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
    compileOnly("org.elasticsearch.client:elasticsearch-rest-high-level-client:7.5.0")
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
