package dev.alejandrozaragoza.validator

import dev.alejandrozaragoza.exception.PersonaException
import dev.alejandrozaragoza.models.Entrenador
import org.lighthousegames.logging.logging

class EntrenadorValidator{
    private val logger = logging()

    fun validateEntrenador(entrenador: Entrenador){
        if (entrenador.nombre.isBlank()){
            throw PersonaException.EntrenadorInvalidoException("Nombre no puede estar en blanco")
        }
        if (entrenador.apellido.isBlank()){
            throw PersonaException.EntrenadorInvalidoException("Apellido no puede estar en blanco")
        }
        if (entrenador.fechaNacimiento.isBlank()){
            throw PersonaException.EntrenadorInvalidoException("La fecha de nacimiento no puede estar en blanco")
        }
        if (entrenador.fechaIncorporacion.isBlank()){
            throw PersonaException.EntrenadorInvalidoException("La fecha de incorporacion no puede estar en blanco")
        }
        if (entrenador.pais.isBlank()){
            throw PersonaException.EntrenadorInvalidoException("Salario no puede estar en blanco")
        }
        if (entrenador.especialidad == null){
            throw PersonaException.EntrenadorInvalidoException("Escepialidad no puede estar en blanco")
        }
    }
}