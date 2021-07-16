data class Points(private var internal: Int = 0) {

    fun next() {
        internal++
    }

    fun areOverForty(): Boolean = internal >= 4

    operator fun minus(other: Points): Int = internal - other.internal

    override fun toString(): String =
            when (internal) {
                0 -> "Love"
                1 -> "Fifteen"
                2 -> "Thirty"
                3 -> "Forty"
                else -> ""
            }

    fun areOverThirty(): Boolean = internal >= 3

}