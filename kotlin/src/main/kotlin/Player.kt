data class Player(val name: String, val points: Points = Points()) {
    fun gainsPoint() {
        points.next()
    }

    fun hasSamePointsOf(player2: Player): Boolean {
        return points == player2.points
    }

    fun hasAdvantageOver(player2: Player): Boolean {
        return points.areOverForty() && (points - player2.points) == 1
    }

    fun hasWonOver(player2: Player): Boolean {
        return points.areOverForty() && (points - player2.points) >= 2
    }

    fun hasOverThirtyPoints(): Boolean {
        return points.areOverThirty()
    }
}