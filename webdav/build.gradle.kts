import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.vanniktech.maven.publish")
}

android {
    namespace = "io.github.webdanlib.webdav.server"
    //noinspection GradleDependency
    compileSdk = 35
    defaultConfig { minSdk = 24 }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_11)
    }
}

dependencies {
    //noinspection UseTomlInstead
    api("org.nanohttpd:nanohttpd:2.3.1")
    //noinspection GradleDependency
    implementation("androidx.core:core-ktx:1.13.1")
}

mavenPublishing {
    coordinates(
        groupId = "io.github.webdanlib",
        artifactId = "webdav",
        version = "0.9.0-SNAPSHOT"
    )

    pom {
        name.set("WebDAV Server Library")
        description.set("Lightweight WebDAV server implementation for Android.")
        inceptionYear.set("2026")
        url.set("https://github.com/webdanlib/webdanlib/webdav")

        licenses {
            license {
                name.set("The Apache Software License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("danielezeobinna")
                name.set("Daniel Eze")
                url.set("https://github.com/danielezeobinna")
            }
        }

        scm {
            url.set("https://github.com/webdanlib/webdanlib")
            connection.set("scm:git:git://github.com/webdanlib/webdanlib.git")
            developerConnection.set("scm:git:ssh://git@github.com:webdanlib/webdanlib.git")
        }
    }

    publishToMavenCentral()
    signAllPublications()
}
