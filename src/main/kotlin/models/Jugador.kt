package dev.alejandrozaragoza.models

import java.time.LocalDate

abstract class Jugador(
    val posicion: Posicion,
    val numero: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidos: Int,
    id: Int,
    nombre: String,
    apellido: String,
    fechaNacimiento: LocalDate,
    fechaIncorporacion: LocalDate,
    salario: Double,
    pais: String
): Persona(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais) {
}

enum class Posicion {
    PORTERO,DEFENSA,CENTROCAMPISTA,DELANTERO
}