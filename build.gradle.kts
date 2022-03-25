plugins{
    kotlin("jvm") version "1.6.10"
}

repositories {
    jcenter()
    mavenCentral()
}

subprojects {
    apply(plugin = "application")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        val implementation by configurations
        implementation("com.squareup.okhttp3:okhttp:4.9.3") // for making requests
        implementation("org.jsoup:jsoup:1.14.3") // for parsing html
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1") // json serialization
    }
}