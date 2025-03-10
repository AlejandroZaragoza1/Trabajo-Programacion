package dev.alejandrozaragoza.dto

import dev.alejandrozaragoza.models.Jugador
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class JugadorDto(
    val posicion: Jugador.Posicion,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidos: Int,
    val id: Long,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String
): java.io.Serializable
