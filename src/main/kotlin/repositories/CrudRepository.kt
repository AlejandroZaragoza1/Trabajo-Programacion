package dev.alejandrozaragoza.repositories

import dev.alejandrozaragoza.models.Persona

interface CrudRepository<T, ID> {
    fun getAll(): List<T>
    fun getById(id: ID): T?
    fun save(item: T): T
    fun update(id: ID, item: T): Persona?
    fun delete(id: ID): T?
}