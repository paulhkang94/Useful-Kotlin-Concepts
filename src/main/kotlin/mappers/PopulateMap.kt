package mappers

/**
 *  various shortcuts for converting array to map of (element : frequency)
 */
object PopulateMap {
    fun IntArray.toFrequencyMap(): Map<Int, Int> {
        val map = hashMapOf<Int, Int>()

        this.forEach {
            map.compute(it) { _, value ->
                if (value == null) 1 else value + 1
            }
        }

        return map
    }
    
    fun <T> Array<T>.toFrequencyMap(): Map<T, Int> {
        return this.groupingBy { it }.eachCount()
    }

    fun <T> MutableMap<T, Int>.incrementCount(element: T) {
        this[element] = this.getOrPut(element) { 0 } + 1
    }

    fun <T, S> MutableMap<T, MutableList<S>>.increment(key: T, value: S) {
        this.computeIfAbsent(key) { mutableListOf() }.add(value)
    }
}