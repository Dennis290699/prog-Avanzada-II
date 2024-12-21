plugins {
    id("java")
    id("io.freefair.lombok") version "8.10.2"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    //implementacion de JPA hibernate
    implementation("org.hibernate:hibernate-core:6.6.4.Final")

    //implemntacion de hibernate comunity dialecto
    implementation("org.hibernate.orm:hibernate-community-dialects:6.6.4.Final")

    //Base de datos: SQLite
    implementation("org.xerial:sqlite-jdbc:3.47.0.0")
}

