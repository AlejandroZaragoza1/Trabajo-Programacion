package dev.alejandrozaragoza.repositories

import dev.alejandrozaragoza.models.Persona

interface PersonaRepository: CrudRepository<Persona, Int> {
}