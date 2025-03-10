package dev.alejandrozaragoza.validator

import dev.alejandrozaragoza.exception.PersonaException
import dev.alejandrozaragoza.models.Jugador
import org.lighthousegames.logging.logging

class JugadorValidator{

    private val logger = logging()

    fun validateJugador(jugador: Jugador){
        if (jugador.nombre.isBlank()){
            throw PersonaException.JugadorInvalidoException("Nombre no puede estar en blanco")
        }
        if (jugador.apellido.isBlank()){
            throw PersonaException.JugadorInvalidoException("Apellido no puede estar en blanco")
        }
        if (jugador.fechaNacimiento.isBlank()){
            throw PersonaException.JugadorInvalidoException("La fecha de nacimiento no puede estar en blanco")
        }
        if (jugador.fechaIncorporacion.isBlank()){
            throw PersonaException.JugadorInvalidoException("La fecha de incorporacion no puede estar en blanco")
        }
        if (jugador.pais.isBlank()){
            throw PersonaException.JugadorInvalidoException("Salario no puede estar en blanco")
        }
        if (jugador.posicion == null){
            throw PersonaException.JugadorInvalidoException("Posicion no puede estar en blanco")
        }
        if (jugador.dorsal == null){
            throw PersonaException.JugadorInvalidoException("Dorsal no puede estar en blanco")
        }
        if (jugador.altura == null){
            throw PersonaException.JugadorInvalidoException("Altura no puede estar en blanco")
        }
        if (jugador.peso == null){
            throw PersonaException.JugadorInvalidoException("Peso no puede estar en blanco")
        }
        if (jugador.goles == null){
            throw PersonaException.JugadorInvalidoException("Goles no puede estar en blanco")
        }
        if (jugador.partidos == null){
            throw PersonaException.JugadorInvalidoException("Partidos jugados no puede estar en blanco")
        }
    }
}