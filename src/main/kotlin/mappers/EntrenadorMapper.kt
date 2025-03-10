package dev.alejandrozaragoza.mappers

import dev.alejandrozaragoza.dto.EntrenadorDto
import dev.alejandrozaragoza.dto.PersonaDto
import dev.alejandrozaragoza.models.Entrenador

fun Entrenador.toDto(): PersonaDto{
    return PersonaDto(
        id = id,
        nombre = nombre,
        apellido = apellido,
        fechaNacimiento = fechaNacimiento,
        fechaIncorporacion = fechaIncorporacion,
        salario = salario!!,
        pais =  pais,
        especialidad = especialidad.toString(),
        posicion = "",
        dorsal = null,
        altura = null,
        peso = null,
        goles = null,
        partidos = null
    )
}

fun EntrenadorDto.toModel(): Entrenador {
    return Entrenador(
        id = this.id,
        nombre = this.nombre,
        apellido = this.apellido,
        fechaNacimiento = this.fechaNacimiento,
        fechaIncorporacion = this.fechaNacimiento,
        salario = this.salario,
        pais = this.pais,
        especialidad = this.especialidad,
    )
}