import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
    kotlin("jvm") version "2.1.20-RC"
    id("com.gradleup.shadow") version "9.0.0-beta10"
    id("de.eldoria.plugin-yml.paper") version "0.7.1"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "dev.thebjoredcraft"
version = "1.0.1-1.21.4"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }

    maven("https://repo.minehub.live/releases")

    maven { url = uri("https://repo.codemc.org/repository/maven-public/") }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    compileOnly("dev.jorel:commandapi-bukkit-core:9.7.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("com.github.shynixn.mccoroutine:mccoroutine-bukkit-api:2.21.0")
    implementation("com.github.shynixn.mccoroutine:mccoroutine-bukkit-core:2.21.0")

    compileOnly("live.minehub:polarpaper:1.21.4.5")
}

paper {
    main = "dev.thebjoredcraft.polarpapertest.PolarpaperTest"
    author = "TheBjoRedCraft"
    apiVersion = "1.21.4"

    serverDependencies {
        register("CommandAPI") {
            required = true
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
        register("polarpaper") {
            required = true
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
    }

}

tasks {
    runServer {
        minecraftVersion("1.21.4")

        downloadPlugins {
            hangar("CommandAPI", "9.7.0")
            github("MinehubMC", "PolarPaper", "1.21.4.5", "polarpaper-1.24.4.5.jar")
        }
    }
}

val targetJavaVersion = 21

kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

