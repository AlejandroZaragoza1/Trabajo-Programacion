package dev.alejandrozaragoza.config

import org.lighthousegames.logging.logging
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import kotlin.io.path.pathString

object Config {
    private val logger = logging()

    val configProperties: ConfigProperties by lazy {
        loadConfig()
    }

    private fun loadConfig(): ConfigProperties {
        logger.debug { "Cargando configuración" }
        val properties = Properties()

        val propertiesStream = this::class.java.getResourceAsStream("/config.properties")
            ?: throw RuntimeException("No se ha encontrado el fichero de configuración")

        properties.load(propertiesStream)

        val directorioActual = System.getProperty("user.dir")
        val dataDirProperty = properties.getProperty("data.directory") ?: "data"
        val backupDirProperty = properties.getProperty("backup.directory") ?: "backup"
        val dataDir = Path.of(directorioActual, dataDirProperty).pathString
        val backupDir = Path.of(directorioActual, backupDirProperty).pathString

        makeProgramDirectories(dataDir, backupDir)
        return ConfigProperties(dataDir, backupDir)
    }

    private fun makeProgramDirectories(vararg directories: String) {
        directories.forEach {
            val dir = java.io.File(it)
            logger.debug { "Creando directorio: $it" }
            Files.createDirectories(dir.toPath())
        }
    }

    data class ConfigProperties(val dataDir: String = "data", val backupDir: String = "backup")
}