plugins {
    kotlin("jvm") version "2.0.20"
}

group = "dev.alejandrozaragoza"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.lighthousegames:logging:1.5.0")
    implementation("ch.qos.logback:logback-classic:1.5.12")

    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.0.0")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")

    implementation("io.github.pdvrieze.xmlutil:serialization-jvm:0.90.3")


    testImplementation("io.mockk:mockk:1.13.16")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}