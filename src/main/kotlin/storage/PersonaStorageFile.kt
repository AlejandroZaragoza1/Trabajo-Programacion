package dev.alejandrozaragoza.storage

import dev.alejandrozaragoza.models.Persona
import java.io.File

interface PersonaStorageFile {
    fun readFromFile(file: File): List<Persona>
    fun writeToFile(persona: List<Persona>, file: File)
}