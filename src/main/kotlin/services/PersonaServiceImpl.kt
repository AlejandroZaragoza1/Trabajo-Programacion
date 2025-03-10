package dev.alejandrozaragoza.services

import dev.alejandrozaragoza.storage.PersonaStorage


private const val  CACHE_SIZE = 50 * 1024 * 1024
class PersonaServiceImpl {
    private val storage: PersonaStorage = PersonaStorageImpl(),
}