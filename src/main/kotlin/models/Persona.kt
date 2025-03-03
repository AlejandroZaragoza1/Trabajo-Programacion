package dev.alejandrozaragoza.models

import java.time.LocalDate

open class Persona(
    val id: Int = NEW_ID,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: LocalDate,
    val fechaIncorporacion: LocalDate,
    val salario: Double,
    val pais: String
) {
    fun copy(id: Int): Persona {
        return Persona(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais)
    }

    companion object{
        val NEW_ID = 1
    }
}