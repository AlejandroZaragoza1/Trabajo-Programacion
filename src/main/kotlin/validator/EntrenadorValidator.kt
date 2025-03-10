package dev.alejandrozaragoza.validator

import dev.alejandrozaragoza.exception.PersonaException
import dev.alejandrozaragoza.models.Entrenador

fun Entrenador.validate(){
    if (nombre.isBlank()){
        throw PersonaException.EntrenadorInvalidoException("Nombre no puede estar en blanco")
    }
    if (apellido.isBlank()){
        throw PersonaException.EntrenadorInvalidoException("Apellido no puede estar en blanco")
    }
    if (fechaNacimiento.isBlank()){
        throw PersonaException.EntrenadorInvalidoException("La fecha de nacimiento no puede estar en blanco")
    }
    if (fechaIncorporacion.isBlank()){
        throw PersonaException.EntrenadorInvalidoException("La fecha de incorporacion no puede estar en blanco")
    }
    if (pais.isBlank()){
        throw PersonaException.EntrenadorInvalidoException("Salario no puede estar en blanco")
    }
    if (pais.isBlank()){
        throw PersonaException.EntrenadorInvalidoException("Pais no puede estar en blanco")
    }
    if (especialidad == null){
        throw PersonaException.EntrenadorInvalidoException("Escepialidad no puede estar en blanco")
    }
}