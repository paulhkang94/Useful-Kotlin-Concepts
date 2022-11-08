package mappers

object PopulateMap {
    // shortcut for converting array to map of (element : frequency)
    fun IntArray.toFrequencyMap(): Map<Int, Int> {
        val map = hashMapOf<Int, Int>()

        this.forEach {
            map.compute(it) { _, value ->
                if (value == null) 1 else value + 1
            }
        }

        return map
    }
}