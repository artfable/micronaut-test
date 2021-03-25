plugins {
    java
    id("io.micronaut.application") version "1.4.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

application {
    mainClass.set("org.example.TestApp")
}

micronaut {
    runtime("netty")
    version("2.4.1")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("org.example.*")
    }
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-inject-java:2.4.1")

    implementation(platform("io.micronaut:micronaut-bom:2.4.1"))
    implementation("javax.annotation:javax.annotation-api")
    implementation("javax.inject:javax.inject:1")

    compileOnly("io.micronaut:micronaut-inject-java")

    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut:micronaut-inject")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.micronaut.rxjava3:micronaut-rxjava3-http-client:1.1.1")
    runtime("io.netty:netty-transport-native-epoll:linux-x86_64")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
