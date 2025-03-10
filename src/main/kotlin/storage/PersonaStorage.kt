package dev.alejandrozaragoza.storage

import dev.alejandrozaragoza.models.Persona
import java.io.File

interface PersonaStorage {
    fun readFromFile(file: File, format: FileFormat)
    fun writeToFile(persona: List<Persona>, file: File, format: FileFormat)
}