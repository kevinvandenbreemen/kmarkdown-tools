plugins {
    kotlin("jvm") version "1.8.21"
    java
    `maven-publish`
    `java-library`
}

group = "com.vandenbreemen.kmarkdown"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    val markdown_version = "0.5.0"
    val kluent_version = "1.73"

    testImplementation(kotlin("test"))

    implementation("org.jetbrains:markdown:$markdown_version")
    testImplementation("org.amshove.kluent:kluent:$kluent_version")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

//  Based on https://github.com/gradle/kotlin-dsl-samples/blob/master/samples/maven-publish/build.gradle.kts
val sourcesJar by tasks.registering(Jar::class) {
    classifier = "sources"
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}