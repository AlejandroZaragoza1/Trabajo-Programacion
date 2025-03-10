package dev.alejandrozaragoza.exception

sealed class PersonaException(message: String): Exception(message) {
    class PersonaStorageException(message: String) : PersonaException("Error en el almacenamiento de producto: $message")
}