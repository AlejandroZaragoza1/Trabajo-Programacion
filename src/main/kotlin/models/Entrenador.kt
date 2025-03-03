package dev.alejandrozaragoza.models

import java.time.LocalDate

class Entrenador(
    val especialidad: Especialidad,
    id: Int = NEW_ID,
    nombre: String,
    apellido: String,
    fechaNacimiento: LocalDate,
    fechaIncorporacion: LocalDate,
    salario: Double,
    pais: String
):Persona(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais){
}

enum class Especialidad{
    PERSONAL,PORTERO,ASISTENTE
}