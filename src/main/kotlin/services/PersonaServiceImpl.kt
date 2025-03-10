package dev.alejandrozaragoza.services

import dev.alejandrozaragoza.Cache.CacheLRU
import dev.alejandrozaragoza.exception.PersonaException
import dev.alejandrozaragoza.models.Persona
import dev.alejandrozaragoza.repositories.PersonaRepository
import dev.alejandrozaragoza.storage.FileFormat
import dev.alejandrozaragoza.storage.PersonaStorage
import org.lighthousegames.logging.logging

private const val  CACHE_SIZE = 5
class PersonaServiceImpl(
    private val repository: PersonaRepository,
    private val cache: CacheLRU<Long, Persona>
) : PersonaService {
    private val logger = logging()
    override fun importFromFile(filePath: String, format: FileFormat) {
        TODO("Not yet implemented")
    }

    override fun exportToFile(filePath: String, format: FileFormat) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Persona> {
        logger.info { "Obteniendo personas" }
        return repository.getAll()
    }

    override fun getById(id: Long): Persona {
        var persona = cache[id]
        // Si existe en cache lo devolvemos
        if (persona != null) {
            logger.info { "Persona encontrada: $persona" }
            return persona
        } else {
            persona = repository.getById(id)
            if (persona != null) {
                logger.info { "Persona encontrada en base de datos: $persona" }
                cache[id] = persona
                return persona
            } else {
                logger.error { "Persona no encontrada en repositorio" }
                throw PersonaException.PersonaStorageException("Vehículo no encontrado con ID: $id")
            }
        }
        override fun delete(id: Int) {
        }
    }

    override fun save(persona: Persona): Persona {
        logger.info { "Guardando vehículo: $persona" }
        validator.validator(persona)
        val newPersona = repository.save(persona)
        cache[newPersona.id] = newPersona
        return newPersona
    }
    }

    override fun update(id: Int, persona: Persona): Persona {
        logger.info { "Actualizando Persona con ID: $id" }
        validator.validate(persona)
        val updatePersona = repository.update(id, persona)
        if (updatePersona == null) {
            logger.error { "Persona no encontrada para actualizar" }
            throw PersonaException.PersonaStorageException("Vehículo no encontrado con ID: $id")
        }
        cache[id] = updatePersona
        return updatePersona
    }
    }
}