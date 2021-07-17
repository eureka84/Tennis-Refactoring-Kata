class TennisGame1(player1Name: String,player2Name: String) : TennisGame {

    private val player1 = Player(player1Name)
    private val player2 = Player(player2Name)

    override fun wonPoint(playerName: String) {
        if (playerName === player1.name) {
            player1.gainsPoint()
        } else {
            player2.gainsPoint()
        }
    }

    override fun getScore(): String = when {
        player1.hasSamePointsOf(player2) -> playersHaveTiedScoreOf(player1.points)
        player1.hasOverFortyPoints() -> player1.mayHaveWonOver(player2)
        player2.hasOverFortyPoints() -> player2.mayHaveWonOver(player1)
        else -> "${player1.points}-${player2.points}"
    }

    private fun Player.mayHaveWonOver(other: Player): String =
        when {
            this.hasOnePointMoreThan(other) ->  "Advantage ${this.name}"
            this.hasOverOnePointMoreThan(other) -> "Win for ${this.name}"
            else -> other.mayHaveWonOver(this)
        }

    private fun playersHaveTiedScoreOf(points: Points) =
        if (points.areOverThirty()) "Deuce" else "${points}-All"

}

