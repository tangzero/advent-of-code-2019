plugins {
    kotlin("jvm") version "1.3.61"
}

allprojects {
    apply(plugin="kotlin")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib"))

        testImplementation(kotlin("test"))
        testImplementation(kotlin("test-junit"))
    }
}
