plugins {
    id("java")
    id("io.freefair.lombok") version "8.10.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val springVersions = "6.2.0"

dependencies {

    // Configuracion de Spring
    implementation("org.springframework:spring-core:${springVersions}")
    implementation("org.springframework:spring-context:${springVersions}")

    //Base de datos: SQLite
    implementation("org.xerial:sqlite-jdbc:3.47.0.0")
    implementation("com.zaxxer:HikariCP:6.1.0")
}