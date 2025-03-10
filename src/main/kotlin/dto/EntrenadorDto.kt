package dev.alejandrozaragoza.dto

import dev.alejandrozaragoza.models.Entrenador
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class EntrenadorDto(
    @SerialName("especialidad")
    val especialidad: Entrenador.Especialidad,
    val id: Long,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String
) {
}