package dev.alejandrozaragoza.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class Entrenador(
    id: Long,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    fechaIncorporacion: String,
    salario: Double?,
    pais: String,
    var especialidad: Especialidad?

) : Persona(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais){

    override fun copy(
        id: Long,
        nombre: String,
        apellido: String,
        fechaNacimiento: String,
        fechaIncorporacion: String,
        salario: Double,
        pais: String
    ): Persona{
        return Entrenador(id, nombre, apellido, fechaNacimiento, fechaIncorporacion, salario, pais, especialidad)
    }

    override fun toString(): String{
        return("Entrenador(id=$id, nombre=$nombre, apellido=$apellido, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, especializacion=$especialidad)")
    }

    @Serializable
    enum class Especialidad {
        @SerialName("especialidad")
        ENTRENADOR_ASISTENTE, ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL
    }
}