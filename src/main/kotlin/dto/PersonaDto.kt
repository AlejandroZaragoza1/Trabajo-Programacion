package dev.alejandrozaragoza.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonaDto(
    @SerialName("id")
    var id: Long,
    @SerialName("nombre")
    var nombre: String,
    @SerialName("apellido")
    var apellido: String,
    @SerialName("fecha_nacimiento")
    var fechaNacimiento: String,
    @SerialName("fecha_incorporacion")
    var fechaIncorporacion: String,
    @SerialName("salario")
    var salario: Double,
    @SerialName("pais")
    var pais: String,
    @SerialName("posicion")
    var posicion: String?,
    @SerialName("dorsal")
    var dorsal: Int?,
    @SerialName("altura")
    var altura: Double?,
    @SerialName("peso")
    var peso: Double?,
    @SerialName("goles")
    var goles: Int?,
    @SerialName("partidos_jugados")
    var partidos: Int?,
    @SerialName("especialidad")
    val especialidad: String
): java.io.Serializable