plugins {
    kotlin("jvm") version "1.8.21"
    application
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

application {
    mainClass.set("MainKt")
}