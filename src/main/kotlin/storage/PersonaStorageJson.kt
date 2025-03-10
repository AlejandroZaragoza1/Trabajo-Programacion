package dev.alejandrozaragoza.storage

import dev.alejandrozaragoza.exception.PersonaException
import dev.alejandrozaragoza.models.Persona
import kotlinx.serialization.json.Json
import org.lighthousegames.logging.logging
import java.io.File

class PersonaStorageJson: PersonaStorageFile {
    private val logger = logging()

    init {
        logger.debug { "Inicializando producto JSON" }
    }

    override fun readFromFile(file: File): List<Persona> {
        logger.debug { "Leyendo fichero JSON: $file" }
        if (!file.exists() || !file.isFile || !file.canRead() || file.length() == 0L || file.name.endsWith(".json")) {
            logger.error { "No es un fichero, no se puede leer o no existe: $file" }
            throw PersonaException.PersonaStorageException("No es un fichero, no se puede leer o no existe: $   file")
        }
        val json =  Json { ignoreUnknownKeys = true }
        return json.decodeFromString<List<Persona>>(file.readText()).map { it.toModel() }
    }

    override fun writeToFile(persona: List<Persona>, file: File) {
        TODO("Not yet implemented")
    }
}