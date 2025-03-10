package dev.alejandrozaragoza.validator

import dev.alejandrozaragoza.exception.PersonaException
import dev.alejandrozaragoza.models.Persona

fun Persona.validate() {
    if (nombre.isBlank()){
        throw PersonaException.PersonaInvalidoException("Nombre no puede estar en blanco")
    }
    if (apellido.isBlank()){
        throw PersonaException.PersonaInvalidoException("Apellido no puede estar en blanco")
    }
    if (fechaNacimiento.isBlank()){
        throw PersonaException.PersonaInvalidoException("La fecha de nacimiento no puede estar en blanco")
    }
    if (fechaIncorporacion.isBlank()){
        throw PersonaException.PersonaInvalidoException("La fecha de incorporacion no puede estar en blanco")
    }
    if (pais.isBlank()){
        throw PersonaException.PersonaInvalidoException("Salario no puede estar en blanco")
    }
    if (pais.isBlank()){
        throw PersonaException.PersonaInvalidoException("Pais no puede estar en blanco")
    }
}