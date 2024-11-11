plugins {
    id("java")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.openwebbeans:openwebbeans-se:4.0.2")
}
