package dev.alejandrozaragoza.validator

import dev.alejandrozaragoza.exception.PersonaException
import dev.alejandrozaragoza.models.Jugador

fun Jugador.validate() {
    if (nombre.isBlank()){
        throw PersonaException.JugadorInvalidoException("Nombre no puede estar en blanco")
    }
    if (apellido.isBlank()){
        throw PersonaException.JugadorInvalidoException("Apellido no puede estar en blanco")
    }
    if (fechaNacimiento.isBlank()){
        throw PersonaException.JugadorInvalidoException("La fecha de nacimiento no puede estar en blanco")
    }
    if (fechaIncorporacion.isBlank()){
        throw PersonaException.JugadorInvalidoException("La fecha de incorporacion no puede estar en blanco")
    }
    if (pais.isBlank()){
        throw PersonaException.JugadorInvalidoException("Salario no puede estar en blanco")
    }
    if (pais.isBlank()){
        throw PersonaException.JugadorInvalidoException("Pais no puede estar en blanco")
    }
    if (posicion == null){
        throw PersonaException.JugadorInvalidoException("Posicion no puede estar en blanco")
    }
    if (dorsal == null){
        throw PersonaException.JugadorInvalidoException("Dorsal no puede estar en blanco")
    }
    if (altura == null){
        throw PersonaException.JugadorInvalidoException("Altura no puede estar en blanco")
    }
    if (peso == null){
        throw PersonaException.JugadorInvalidoException("Peso no puede estar en blanco")
    }
    if (goles == null){
        throw PersonaException.JugadorInvalidoException("Goles no puede estar en blanco")
    }
    if (partidos == null){
        throw PersonaException.JugadorInvalidoException("Partidos jugados no puede estar en blanco")
    }
}