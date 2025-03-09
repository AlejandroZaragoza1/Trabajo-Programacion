package dev.alejandrozaragoza.Cache

const val CACHE_SIZE = 5
interface Cache<K, V> {
    fun get(key: K): V?
    fun set(key: K, value: V): V?
    fun remove(key: K): V?
    fun clear()
    fun size(): Int
    fun isEmpty(): Boolean
    fun keys(): Set<K>
    fun values(): Collection<V>

}