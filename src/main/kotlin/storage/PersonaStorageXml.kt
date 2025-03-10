package dev.alejandrozaragoza.storage

import dev.alejandrozaragoza.dto.PersonaDto
import dev.alejandrozaragoza.exception.PersonaException
import dev.alejandrozaragoza.mappers.toModel
import dev.alejandrozaragoza.models.Persona
import kotlinx.serialization.decodeFromString
import nl.adaptivity.xmlutil.serialization.XML
import org.lighthousegames.logging.logging
import java.io.File

class PersonaStorageXml: PersonaStorageFile {
    private val logger = logging()

    init {
        logger.debug { "Inicializando almacenamiento XML" }
    }


    override fun readFromFile(file: File): List<Persona> {
        logger.debug { "Leyendo fichero XML: $file" }
        if (!file.exists() || !file.isFile || !file.canRead() || file.length() == 0L || !file.name.endsWith(
            ".xml",
            true
            )
        ) {
            logger.error { "El fichero no existe, no se puede leer o no es un fichero: $file" }
            throw PersonaException.PersonaStorageException("El fichero no existe, no se puede leer o no es un fichero: $file")
        }
        val json = XML {}
        val xmlString = file.readText()
        val personaDto = json.decodeFromString<PersonaDto>(xmlString)
        val personaListDto = personaDto.persona
        return personaListDto.map { it.toModel() }
    }

    override fun writeToFile(persona: List<Persona>, file: File) {
        logger.debug { "Escribiendo producto XML: $file" }
        if (!file.parentFile.exists() || !file.parentFile.isDirectory || !file.name.endsWith(".xml", true)) {
            logger.error { "El directorio padre del fichero no existe: ${file.parentFile.absolutePath}" }
            throw PersonaException.PersonaStorageException("El directorio padre del fichero no existe: ${file.parentFile.absolutePath}")
        }
        val json = XML {indent = 4}
        val personaListDto = persona.map { it.toDto() }
        val personaDto = PersonaDto(personaListDto)
        file.writeText(json.encodeToString<PersonaDto>(personaDto))
    }
}