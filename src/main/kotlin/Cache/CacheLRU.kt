package dev.alejandrozaragoza.Cache
import org.lighthousegames.logging.logging



open class CacheLRU <K, V>(private val capacity: Int = CACHE_SIZE): Cache<K, V> {
    private val logger = logging()

    private val cache = object : LinkedHashMap<K, V>(capacity) {}

    override fun get(key: K): V? {
        logger.debug { "Valor de la cache $key" }
        return cache[key]
    }
    override fun set(key: K, value: V): V? {
        logger.debug { "Guardando valor en la cache con clave $key" }
        cache[key] = value
        return value
    }

    override fun remove(key: K): V? {
        logger.debug { "Eliminando valor de la cache con clave $key" }
        return cache.remove(key)
    }

    override fun clear() {
        logger.debug { "Limpiando la cache" }
        return cache.clear()
    }

    override fun size(): Int {
        logger.debug { "Obteniendo tamaño" }
        return cache.size
    }

    override fun isEmpty(): Boolean = cache.isEmpty()

    override fun values(): Collection<V> {
        return cache.values
    }
    override fun keys(): Set<K> = cache.keys

}