package dev.alejandrozaragoza


import dev.alejandrozaragoza.models.*
import dev.alejandrozaragoza.services.CSVservices
import java.io.File
import java.time.LocalDate

import dev.alejandrozaragoza.models.Persona
import dev.alejandrozaragoza.Cache.CacheLRU

fun main() {
    val cache = object : CacheLRU<Int, Persona>(5) {} // Cache de 5 elementos

    println("Añadiendo 5 personas a la cache...")
    repeat(5) { index ->
        val persona = Persona(
            id = index,
            nombre = "Persona$index",
            apellido = "Apellido$index",
            fechaNacimiento = java.time.LocalDate.of(1990, 1, 1),
            fechaIncorporacion = java.time.LocalDate.now(),
            salario = 1000.0,
            pais = "España"
        )
        cache[index] = persona
    }

    println("Cache actual (debería haber 5 personas):")
    cache.values().forEach { println(it) }

    println("\nAccedemos a la persona con id 0 para actualizar su 'uso' en la cache...")
    cache[0] // Esto la hace "reciente"

    println("\nAñadiendo una persona nueva (esto debería expulsar la menos usada, que sería id=1)...")
    val nuevaPersona = Persona(
        id = 5,
        nombre = "NuevaPersona",
        apellido = "NuevoApellido",
        fechaNacimiento = java.time.LocalDate.of(2000, 1, 1),
        fechaIncorporacion = java.time.LocalDate.now(),
        salario = 2000.0,
        pais = "México"
    )
    cache[5] = nuevaPersona

    println("\nCache actual después de añadir la sexta persona:")
    cache.values().forEach { println(it) }

    println("\nVerifica que ya no está la persona con id=1 (porque fue la menos usada)...")
    println("Persona con id=1 está: ${cache[1] != null}")
    println("Persona con id=0 está: ${cache[0] != null}")
}

