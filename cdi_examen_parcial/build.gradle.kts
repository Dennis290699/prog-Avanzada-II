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
    //Contenedor CDI: Weld
    implementation("org.jboss.weld.se:weld-se-core:5.1.3.Final")
    implementation("io.smallrye:jandex:3.2.3")

    //Base de datos: SQLite
    implementation("org.xerial:sqlite-jdbc:3.47.0.0")
    implementation("com.zaxxer:HikariCP:6.1.0")

    //MongoDB
    implementation("org.mongodb:mongodb-driver-sync:5.2.1")

    //configuracion
    implementation("org.apache.deltaspike.core:deltaspike-core-api:2.0.0")
    implementation("org.apache.deltaspike.core:deltaspike-core-impl:2.0.0")
}

sourceSets {
    main {
        output.setResourcesDir( file("${buildDir}/classes/java/main") )
    }
}