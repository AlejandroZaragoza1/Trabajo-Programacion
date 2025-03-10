package dev.alejandrozaragoza.services

import dev.alejandrozaragoza.storage.PersonaStorage


private const val  CACHE_SIZE = 5
class PersonaServiceImpl {
    private val storage: PersonaStorage = PersonaStorageImpl(),
}