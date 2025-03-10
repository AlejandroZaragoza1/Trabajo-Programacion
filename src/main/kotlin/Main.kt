package dev.alejandrozaragoza

import dev.alejandrozaragoza.models.Persona
import dev.alejandrozaragoza.repositories.PersonaRepositoryImpl
import dev.alejandrozaragoza.storage.*
import kotlin.io.path.Path

fun main() {
    while (true){
        println("Menú Personal del club")
        println("Selecciona una opción")
        println("1. Cargar datos desde fichero según la especificación indicada")
        println("2. Crear miembro del equipo")
        println("3. Actualizar miembro de equipo")
        println("4. Eliminar miembro del equipo")
        println("5. Copiar datos a fichero según la especificación realizada")
        println("6. Realizar consultas indicadas")
        println("7. Salir")

        when(readLine()!!.toInt()){
            1 -> cargarDatos(personaRepository = PersonaRepositoryImpl())
            2 -> crearMiembros(personaRepository = PersonaRepositoryImpl())
            3 -> actualizarMiembros(personaRepository = PersonaRepositoryImpl())
            4 -> eliminarMiembros(personaRepository = PersonaRepositoryImpl())
            5 -> copiarDatos(personaRepository = PersonaRepositoryImpl())
            6 -> consultas(personaRepository = PersonaRepositoryImpl())
            7 -> return
            else -> println("Opción no válida")
        }
    }
}

fun cargarDatos(personaRepository: PersonaRepositoryImpl) {
    println("Elige formato de archivos: \n1. XML \n2. CSV \n3. JSON \n4. BIN ")

    val formato = readln().toIntOrNull() ?:0
    val filePath = when (formato) {
        1 -> "data/personal.xml"
        2 -> "data/personal (1).csv"
        3 -> "data/personal.json"
        4 -> "data/personal.bin"
        else -> {
            println("Formato no válido")
            return
        }
    }
}