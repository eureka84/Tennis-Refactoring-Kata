data class Player(val name: String, val points: Points = Points()) {

    fun gainsPoint() {
        points.next()
    }

    fun hasSamePointsOf(other: Player): Boolean = points == other.points

    fun hasOnePointMoreThan(other: Player): Boolean = (points - other.points) == 1

    fun hasOverOnePointMoreThan(other: Player): Boolean = (points - other.points) > 1

    fun hasOverFortyPoints(): Boolean = points.areOverForty()
}