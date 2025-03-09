package dev.alejandrozaragoza.models

import java.time.LocalDate

enum class Posicion {
    PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO
}

class Jugador(
    id: Int,
    nombre: String,
    apellido: String,  // Asegúrate de que sea "apellido" y no "apellidos"
    fechaNacimiento: LocalDate,
    fechaIncorporacion: LocalDate,
    salario: Double,
    pais: String,
    val posicion: Posicion,
    val numero: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidos: Int
) : Persona(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais) {
    override fun toString(): String {
        return "Jugador(id=$id, nombre=$nombre, apellido=$apellido, fechaNacimiento=$fechaNacimiento, " +
                "fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, " +
                "posicion=$posicion, numero=$numero, altura=$altura, peso=$peso, goles=$goles, partidos=$partidos)"
    }
}
