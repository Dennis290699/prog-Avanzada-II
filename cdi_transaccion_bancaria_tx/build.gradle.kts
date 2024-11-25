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
    implementation("org.postgresql:postgresql:42.7.4")

    //JTA
    implementation("io.helidon.integrations.cdi:helidon-integrations-cdi-jta-weld:4.1.4")

    //Configuraciones
    implementation("org.apache.deltaspike.core:deltaspike-core-api:2.0.0")
    implementation("org.apache.deltaspike.core:deltaspike-core-impl:2.0.0")
}

sourceSets {
    main {
        output.setResourcesDir(file("${buildDir}/classes/java/main"))
    }
}
