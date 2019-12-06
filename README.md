[![GitHub Actions](https://img.shields.io/github/workflow/status/reimersoftware/tex-gradle-plugin/Gradle%20CI?style=flat-square)](https://github.com/reimersoftware/tex-gradle-plugin/actions)
[![Gradle plugin portal](https://img.shields.io/maven-metadata/v/https/plugins.gradle.org/m2/dev/reimer/tex/dev.reimer.tex.gradle.plugin/maven-metadata.xml.svg?label=gradle&style=flat-square)](https://plugins.gradle.org/plugin/dev.reimer.tex)
[![JitPack](https://img.shields.io/jitpack/v/github/reimersoftware/tex-gradle-plugin?style=flat-square)](https://jitpack.io/#dev.reimer/tex-gradle-plugin)




[![JitPack](https://jitpack.io/v/dev.reimer/elasticsearch-ktx.svg)](https://jitpack.io/#dev.reimer/elasticsearch-ktx)

# elasticsearch-ktx<sup>[α](#status-α)</sup>

Kotlin extensions for the Elasticsearch [Java High Level REST Client](https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high.html) (unofficial).

## Gradle Dependency

This library is available on [**jitpack.io**](https://jitpack.io/#dev.reimer/elasticsearch-ktx).  
Add this in your `build.gradle.kts` or `build.gradle` file:

<details open><summary>Kotlin</summary>

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("dev.reimer:elasticsearch-ktx:<version>")
}
```

</details>

<details><summary>Groovy</summary>

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'dev.reimer:elasticsearch-ktx:<version>'
}
```

</details>

## ToDo's

- Check API changes from 6.8.2 to 7.5.0.
- Add `IndexLifecycleClient` extensions.
- Add `CcrClient` extensions.
- Add `TransformClient` extensions.
- Add `EnrichClient` extensions.

## Status α

⚠️ _Warning:_ This project is in an experimental alpha stage:
- The API may be changed at any time without further notice.
- Development still happens on `master`.
- Pull Requests are highly appreciated!