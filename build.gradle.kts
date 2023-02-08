import com.github.jengelman.gradle.plugins.shadow.tasks.ConfigureShadowRelocation
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import net.ltgt.gradle.errorprone.errorprone

plugins {
    `java-gradle-plugin`
    `maven-publish`
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "0.14.0"
    id("com.diffplug.spotless") version "6.14.1"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("net.ltgt.errorprone") version "3.0.1"
}

repositories {
    maven {
        url = uri("https://jitpack.io")
        content {
            includeGroup("com.github.crowdin")
        }
    }
    mavenCentral()
}

group = "org.zaproxy.gradle"
version = "0.4.0-SNAPSHOT"

val shadowImplementation by configurations.creating
configurations["compileOnly"].extendsFrom(shadowImplementation)
configurations["testImplementation"].extendsFrom(shadowImplementation)

dependencies {
    shadowImplementation("com.github.crowdin:crowdin-api-client-java:1.5.3") {
        exclude(group = "org.projectlombok")
        exclude(group = "org.apache.httpcomponents")
        exclude(group = "com.fasterxml.jackson.core")
    }

    val jacksonVersion = "2.12.3"
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")

    implementation("org.apache.commons:commons-lang3:3.4")
    implementation("org.apache.httpcomponents:httpclient:4.5.3")
    implementation("org.projectlombok:lombok:1.18.10")

    testImplementation("org.assertj:assertj-core:3.24.2")
    val jupiterVersion = "5.9.2"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$jupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")

    "errorprone"("com.google.errorprone:error_prone_core:2.18.0")
}

java {
    val javaVersion = JavaVersion.VERSION_11
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.compilerArgs = listOf("-Xlint:all", "-Xlint:-path", "-Xlint:-options", "-Werror")
    options.errorprone {
        disableAllChecks.set(true)
        error(
            "MissingOverride",
            "WildcardImport",
        )
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

spotless {
    java {
        licenseHeaderFile("gradle/spotless/license.java")
        googleJavaFormat("1.7").aosp()
    }

    kotlinGradle {
        ktlint()
    }
}

val pluginName = "crowdin"
gradlePlugin {
    (plugins) {
        create(pluginName) {
            id = "org.zaproxy.crowdin"
            implementationClass = "org.zaproxy.gradle.crowdin.CrowdinPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/zaproxy/gradle-plugin-crowdin"
    vcsUrl = "https://github.com/zaproxy/gradle-plugin-crowdin.git"
    description = "A Gradle plugin to integrate with Crowdin."
    tags = listOf("crowdin")

    (plugins) {
        pluginName {
            displayName = "Plugin to integrate with Crowdin"
        }
    }
}

val relocateShadowJar by tasks.registering(ConfigureShadowRelocation::class) {
    target = tasks.shadowJar.get()
}
val shadowJarTask = tasks.named<ShadowJar>("shadowJar") {
    dependsOn(relocateShadowJar)
    archiveClassifier.set("")
    configurations = listOf(shadowImplementation)
}

configurations {
    artifacts {
        runtimeElements(shadowJarTask)
        apiElements(shadowJarTask)
    }
}

tasks.whenTaskAdded {
    if (name == "publishPluginJar" || name == "generateMetadataFileForPluginMavenPublication") {
        dependsOn(tasks.named("shadowJar"))
    }
}

tasks.named("jar").configure {
    enabled = false
}

afterEvaluate {
    publishing {
        publications {
            withType<MavenPublication> {
                if (name == "pluginMaven") {
                    setArtifacts(listOf(shadowJarTask.get()))
                }
            }
        }
    }
}
