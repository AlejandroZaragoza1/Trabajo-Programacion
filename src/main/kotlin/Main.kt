package dev.alejandrozaragoza

fun main() {
    val csvService = CSVServices()
    val personas = csvService.readCSV()
    for (persona in personas) {
        println(persona)
    }
}