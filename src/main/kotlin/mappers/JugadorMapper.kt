package dev.alejandrozaragoza.mappers

import dev.alejandrozaragoza.dto.JugadorDto
import dev.alejandrozaragoza.dto.PersonaDto
import dev.alejandrozaragoza.models.Jugador
import dev.alejandrozaragoza.models.Persona

fun Jugador.toDto(): PersonaDto {
    return PersonaDto(
        id = id,
        nombre = nombre,
        apellido = apellido,
        fechaNacimiento = fechaNacimiento,
        fechaIncorporacion = fechaIncorporacion,
        salario = salario!!,
        pais = pais,
        posicion = posicion.toString(),
        dorsal = dorsal,
        altura = altura,
        peso = peso,
        goles = goles,
        partidos = partidos,
        especialidad = ""
    )
}

fun JugadorDto.toModel(): Persona {
    return Jugador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento,
        fechaIncorporacion = this.fechaIncorporacion,
        salario = this.salario,
        pais = this.pais,
        posicion = this.posicion,
        dorsal = this.dorsal,
        altura = this.altura,
        peso = this.peso,
        goles = this.goles,
        partidos = this.partidos
    )
}