class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var scorePlayer1 = Score()
    private var scorePlayer2 = Score()

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name) {
            scorePlayer1.next()
        } else {
            scorePlayer2.next()
        }
    }

    override fun getScore(): String = when {
        scorePlayer1 == scorePlayer2 -> tiedScore()
        scorePlayer1.hasAdvantageOver(scorePlayer2) -> "Advantage $player1Name"
        scorePlayer2.hasAdvantageOver(scorePlayer1) -> "Advantage $player2Name"
        scorePlayer1.hasWonOver(scorePlayer2) -> "Win for $player1Name"
        scorePlayer2.hasWonOver(scorePlayer1) -> "Win for $player2Name"
        else -> runningGameScore()
    }

    private fun tiedScore() =
            if (scorePlayer1.isOverThirty()) {
                "Deuce"
            } else {
                scorePlayer1.asString() + "-All"
            }

    private fun runningGameScore(): String = "${scorePlayer1.asString()}-${scorePlayer2.asString()}"

}

data class Score(private var internal: Int = 0) {

    fun next() {
        internal++
    }

    private fun isOverForty(): Boolean = internal >= 4

    fun hasAdvantageOver(other: Score): Boolean {
        return isOverForty() && (internal - other.internal) == 1
    }

    fun hasWonOver(other: Score): Boolean {
        return isOverForty() && (internal - other.internal) >= 2
    }

    fun asString(): String =
            when (internal) {
                0 -> "Love"
                1 -> "Fifteen"
                2 -> "Thirty"
                3 -> "Forty"
                else -> ""
            }

    fun isOverThirty(): Boolean = internal >= 3

}
