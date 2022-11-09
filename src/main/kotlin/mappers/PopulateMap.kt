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
}