package dev.alejandrozaragoza.mappers

import dev.alejandrozaragoza.dto.PersonaDto
import dev.alejandrozaragoza.models.Entrenador
import dev.alejandrozaragoza.models.Jugador
import dev.alejandrozaragoza.models.Persona

fun PersonaDto.toEntrenador(): Entrenador {
    return Entrenador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento,
        fechaIncorporacion = this.fechaIncorporacion,
        salario = this.salario,
        pais = this.pais,
        especialidad = Entrenador.Especialidad.valueOf(especialidad!!)
    )
}

fun PersonaDto.toJugador(): Jugador {
    return Jugador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento,
        fechaIncorporacion = this.fechaIncorporacion,
        salario = this.salario,
        pais = this.pais,
        posicion = Jugador.Posicion.valueOf(posicion!!),
        dorsal = this.dorsal ?: 0,
        altura = this.altura ?: 0.0,
        peso = this.peso ?: 0.0,
        goles = this.goles ?: 0,
        partidos = this.partidos ?: 0
    )
}
