import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
    maven
    id("org.jetbrains.dokka") version "0.9.17"
}

group = "com.heinrichreimer"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")
//    compile("org.elasticsearch.client:transport:6.5.2")
    compile("org.elasticsearch.client:elasticsearch-rest-high-level-client:6.5.2")
}

// Compile Kotlin to JVM1.6 bytecode.
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.6"
}

// Include project license in generated JARs.
tasks.withType<Jar> {
    from(project.projectDir) {
        include("LICENSE")
        into("META-INF")
    }
}

// Generate Kotlin/Java documentation from sources.
val dokka by tasks.getting(DokkaTask::class) {
    outputFormat = "html"
    outputDirectory = "$buildDir/javadoc"
}

// JAR containing Kotlin/Java documentation.
val javadocJar by tasks.creating(Jar::class) {
    dependsOn(dokka)
    classifier = "javadoc"
    from(dokka.outputDirectory)
}

// JAR containing all source files.
val sourcesJar by tasks.creating(Jar::class) {
    dependsOn("classes")
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

artifacts {
    add("archives", sourcesJar)
    add("archives", javadocJar)
}

