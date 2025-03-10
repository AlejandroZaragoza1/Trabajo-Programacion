package dev.alejandrozaragoza.models

import kotlinx.serialization.Serializable


@Serializable
abstract class Persona(
    val id: Long,
    var nombre: String,
    var apellido: String,
    var fechaNacimiento: String,
    var fechaIncorporacion: String,
    var salario: Double?,
    var pais: String,
) {

    companion object{
        val NEW_ID = 1L
    }

    abstract fun copy(
        id: Long = this.id,
        nombre: String = this.nombre,
        apellido: String = this.apellido,
        fechaNacimiento: String = this.fechaNacimiento,
        fechaIncorporacion: String = this.fechaNacimiento,
        salario: Double = this.salario!!,
        pais: String = this.pais,
    ): Persona
}