package dev.alejandrozaragoza.validator

import dev.alejandrozaragoza.exception.PersonaException
import dev.alejandrozaragoza.models.Persona
import org.lighthousegames.logging.logging

class PersonaValidator{
    private val logger = logging()

    fun validatePersona(persona: Persona){
        if (persona.nombre.isBlank()){
            throw PersonaException.PersonaInvalidoException("Nombre no puede estar en blanco")
        }
        if (persona.apellido.isBlank()){
            throw PersonaException.PersonaInvalidoException("Apellido no puede estar en blanco")
        }
        if (persona.fechaNacimiento.isBlank()){
            throw PersonaException.PersonaInvalidoException("La fecha de nacimiento no puede estar en blanco")
        }
        if (persona.fechaIncorporacion.isBlank()){
            throw PersonaException.PersonaInvalidoException("La fecha de incorporacion no puede estar en blanco")
        }
        if (persona.pais.isBlank()){
            throw PersonaException.PersonaInvalidoException("Salario no puede estar en blanco")
        }
        if (persona.pais.isBlank()){
            throw PersonaException.PersonaInvalidoException("Pais no puede estar en blanco")
        }
    }
}