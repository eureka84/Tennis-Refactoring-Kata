class TennisGame1(player1Name: String,player2Name: String) : TennisGame {

    private var player1 = Player(player1Name)
    private var player2 = Player(player2Name)

    override fun wonPoint(playerName: String) {
        if (playerName === player1.name) {
            player1.gainsPoint()
        } else {
            player2.gainsPoint()
        }
    }

    override fun getScore(): String = when {
        player1.hasSamePointsOf(player2) -> tiedScore(player1.points)
        player1.hasAdvantageOver(player2) -> "Advantage ${player1.name}"
        player2.hasAdvantageOver(player1) -> "Advantage ${player2.name}"
        player1.hasWonOver(player2) -> "Win for ${player1.name}"
        player2.hasWonOver(player1) -> "Win for ${player2.name}"
        else -> "${player1.points}-${player2.points}"
    }

    private fun tiedScore(points: Points) =
        if (points.areOverThirty()) "Deuce" else "${points}-All"

}

