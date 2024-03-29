val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

val postgres_version: String by project
val h2_version: String by project
val exposed_version: String by project
val flyway_version: String by project

plugins {
    kotlin("jvm") version "1.9.10"
    id("io.ktor.plugin") version "2.3.4"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
    id("io.gitlab.arturbosch.detekt") version ("1.23.1")
    id("org.openapi.generator") version ("6.6.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(19))
    }
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:2.3.6")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:2.3.6")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:2.3.6")
    implementation("io.ktor:ktor-server-openapi:$ktor_version")
    implementation("io.ktor:ktor-server-swagger:$ktor_version")
    implementation("org.postgresql:postgresql:$postgres_version")
    implementation("com.h2database:h2:$h2_version")
    implementation("io.ktor:ktor-server-cors-jvm:2.3.6")
    implementation("io.ktor:ktor-server-host-common-jvm:2.3.6")
    implementation("io.ktor:ktor-server-auth-jvm:2.3.6")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:2.3.6")
    implementation("io.ktor:ktor-server-netty-jvm:2.3.6")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:2.3.6")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.flywaydb:flyway-core:$flyway_version")
    implementation("org.flywaydb:flyway-database-postgresql:$flyway_version")
    implementation("org.openapitools:openapi-generator-gradle-plugin:7.0.1")

    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    testImplementation("io.ktor:ktor-server-test-host-jvm:2.3.6")
}

tasks.withType<Test> {
    environment("DB_URI", "localhost:5433/")
    environment("DB_PASSWORD", "password")
    environment("DB_USER", "username")
    useJUnitPlatform()
}

detekt {
    autoCorrect = true
    source.setFrom("src/main/kotlin", "src/test/kotlin")
}

openApiGenerate {
    generatorName.set("typescript-axios")
    inputSpec.set("./src/main/resources/openapi/documentation.yaml")
    outputDir.set("$buildDir/generated")
    configOptions.put("withInterfaces", "true")
    configOptions.put("supportsES6", "true")
    logToStderr = true
}

openApiValidate {
    inputSpec.set("./src/main/resources/openapi/documentation.yaml")
}
