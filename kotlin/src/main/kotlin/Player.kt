data class Player(val name: String, val points: Points = Points()) {

    fun gainsPoint() {
        points.next()
    }

    fun hasSamePointsOf(other: Player): Boolean = points == other.points

    fun hasAdvantageOver(other: Player): Boolean = points.areOverForty() && (points - other.points) == 1

    fun hasWonOver(other: Player): Boolean = points.areOverForty() && (points - other.points) >= 2

    fun hasOverFortyPoints(): Boolean = points.areOverForty()
}