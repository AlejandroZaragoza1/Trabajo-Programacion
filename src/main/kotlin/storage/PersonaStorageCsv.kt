package dev.alejandrozaragoza.storage

import dev.alejandrozaragoza.models.Persona
import org.lighthousegames.logging.logging
import java.io.File

class PersonaStorageCsv {
    private val logger = logging()

    init {
        logger.debug { "Almacenamiento CSV" }
    }

    fun readCSV(): List<Persona> {
        val file = File("Data", "personal (1).csv")
        logger.debug { "Leyendo CSV" }

        if (!file.exists() || !file.canRead()) {
            logger.error { "Fichero inexistente o no se puede leer" }
            throw IllegalArgumentException("El fichero no existe o no se puede leer")
        }

        return file.readLines()
            .drop(1) // Saltamos el encabezado
            .map { line -> line.split(",") }
            .map { item ->
                val id = item[0].trim().toInt()
                val nombre = item[1].trim()
                val apellidos = item[2].trim()
                val fechaNacimiento = LocalDate.parse(item[3].trim())
                val fechaIncorporacion = LocalDate.parse(item[4].trim())
                val salario = item[5].trim().toDouble()
                val pais = item[6].trim()
                val rol = item[7].trim()

                when (rol) {
                    "Entrenador" -> {
                        val especialidad = when (item.getOrNull(8)?.trim()) {
                            "ENTRENADOR_PRINCIPAL" -> Especialidad.PERSONAL
                            "ENTRENADOR_PORTEROS" -> Especialidad.PORTERO
                            "ENTRENADOR_ASISTENTE" -> Especialidad.ASISTENTE
                            else -> Especialidad.PERSONAL // Valor por defecto en caso de error
                        }
                        Entrenador(
                            id = id,
                            nombre = nombre,
                            apellido = apellidos,
                            fechaNacimiento = fechaNacimiento,
                            fechaIncorporacion = fechaIncorporacion,
                            salario = salario,
                            pais = pais,
                            especialidad = especialidad
                        )
                    }

                    "Jugador" -> {
                        val posicion = when (item.getOrNull(9)?.trim()) {
                            "PORTERO" -> Posicion.PORTERO
                            "DEFENSA" -> Posicion.DEFENSA
                            "CENTROCAMPISTA" -> Posicion.CENTROCAMPISTA
                            "DELANTERO" -> Posicion.DELANTERO
                            else -> throw IllegalArgumentException("Posición desconocida: ${item.getOrNull(9)}")
                        }
                        val dorsal = item.getOrNull(10)?.trim()?.toIntOrNull() ?: 0
                        val altura = item.getOrNull(11)?.trim()?.toDoubleOrNull() ?: 0.0
                        val peso = item.getOrNull(12)?.trim()?.toDoubleOrNull() ?: 0.0
                        val goles = item.getOrNull(13)?.trim()?.toIntOrNull() ?: 0
                        val partidos = item.getOrNull(14)?.trim()?.toIntOrNull() ?: 0

                        Jugador(
                            id = id,
                            nombre = nombre,
                            apellido = apellidos,
                            fechaNacimiento = fechaNacimiento,
                            fechaIncorporacion = fechaIncorporacion,
                            salario = salario,
                            pais = pais,
                            posicion = posicion,
                            numero = dorsal,
                            altura = altura,
                            peso = peso,
                            goles = goles,
                            partidos = partidos
                        )
                    }

                    else -> {
                        throw IllegalArgumentException("Rol desconocido: $rol")
                    }
                }
            }
    }
}