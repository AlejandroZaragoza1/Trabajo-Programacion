package dev.alejandrozaragoza.exception

sealed class PersonaException(message: String): Exception(message) {
    class PersonaStorageException(message: String) : PersonaException("Error en el almacenamiento de producto: $message")
    class PersonaInvalidoException(message: String) : PersonaException("Persona no válido: $message")
    class EntrenadorInvalidoException(message: String) : PersonaException("Entrenador no válido: $message")
    class JugadorInvalidoException(message: String) : PersonaException("Jugador no válido: $message")
}