package dev.alejandrozaragoza.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class Jugador(
    id: Long,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    fechaIncorporacion: String,
    salario: Double?,
    pais: String,
    var posicion: Posicion?,
    var dorsal: Int?,
    var altura: Double?,
    var peso: Double?,
    var goles: Int,
    var partidos: Int
): Persona(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais) {

    override fun toString(): String {
        return ("Jugador(id=$id, nombre=$nombre, apellido=$apellido, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, posiciom=$posicion, dorsal=$dorsal, altura=$altura, peso=$peso, goles=$goles, partidosJugados=$partidos )")
    }

    override fun copy(
        id: Long,
        nombre: String,
        apellido: String,
        fechaNacimiento: String,
        fechaIncorporacion: String,
        salario: Double,
        pais: String
    ): Persona {
        return Jugador(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais, posicion, dorsal, altura, peso, goles, partidos)
    }

    /**
     * Enum que representa las posibles posiciones de un jugador en el campo.
     */
    @Serializable
    enum class Posicion {
        @SerialName("posicion")
        DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO, NINGUNO
    }
}