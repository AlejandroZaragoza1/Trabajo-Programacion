package dev.alejandrozaragoza.services

import dev.alejandrozaragoza.models.Persona
import dev.alejandrozaragoza.storage.FileFormat

interface PersonaService {
    fun importFromFile(filePath: String, format: FileFormat = FileFormat.JSON)
    fun exportToFile(filePath: String, format: FileFormat = FileFormat.JSON)

    fun getAll(): List<Persona>
    fun getById(id: Long): Persona
    fun save(persona: Persona): Persona
    fun update(id: Int, persona: Persona): Persona
}