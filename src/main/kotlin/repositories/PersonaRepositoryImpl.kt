package dev.alejandrozaragoza.repositories

import dev.alejandrozaragoza.models.Persona
import org.lighthousegames.logging.logging
import java.time.LocalDateTime

class PersonaRepositoryImpl: PersonaRepository {
    private val logger = logging()
    private val persona = mutableMapOf<Int, Persona>()


    override fun getAll(): List<Persona> {
        logger.debug { "Obteniendo todo persona" }
        return persona.values.toList()
    }

    override fun getById(id: Int): Persona? {
        logger.debug { "Obteniendo persona por ID: $id" }
        return persona[id]
    }

    override fun save(item: Persona): Persona {
        logger.debug { "Guardando persona: $item" }
        val id = persona.keys.maxOrNull()?.plus(1) ?: 1
        persona[id] = item.copy(id = id)
        return persona[id]!!
    }

    override fun update(id: Int, item: Persona): Persona? {
        logger.debug { "Actualizando persona: $item" }
        return persona.put(id, item)
    }

    override fun delete(id: Int): Persona? {
        logger.debug { "Borrando persona: $id" }
        return persona.remove(id)
    }
}