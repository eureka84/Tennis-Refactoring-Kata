data class Player(val name: String, val points: Points = Points()) {

    fun gainsPoint() {
        points.next()
    }

    infix fun hasSamePointsOf(other: Player): Boolean = points == other.points

    infix fun hasOnePointMoreThan(other: Player): Boolean = (points - other.points) == 1

    infix fun hasOverOnePointMoreThan(other: Player): Boolean = (points - other.points) > 1

    fun hasOverFortyPoints(): Boolean = points.areOverForty()
}