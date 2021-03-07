class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var player1Score: Int = 0
    private var scorePlayer1 = Score()
    private var player2Score: Int = 0
    private var scorePlayer2 = Score()

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name) {
            player1Score += 1
            scorePlayer1.next()
        } else {
            player2Score += 1
            scorePlayer2.next()
        }
    }

    override fun getScore(): String = when {
        isTied() -> tiedScore(scorePlayer1)
        eitherPlayersOver40() -> finalScore()
        else -> runningGameScore()
    }

    private fun tiedScore(score: Score): String =
            if (score.isOverThirty()) {
                "Deuce"
            } else {
                score.asString() + "-All"
            }

    private fun finalScore(): String = when {
        scorePlayer1.hasAdvantageOver(scorePlayer2) -> "Advantage $player1Name"
        scorePlayer2.hasAdvantageOver(scorePlayer1) -> "Advantage $player2Name"
        scorePlayer1.hasWonOver(scorePlayer2) -> "Win for $player1Name"
        else -> "Win for $player2Name"
    }

    private fun runningGameScore(): String =
            "${scoreStringFor(player1Score)}-${scoreStringFor(player2Score)}"

    private fun scoreStringFor(tempScore: Int) =
            when (tempScore) {
                0 -> "Love"
                1 -> "Fifteen"
                2 -> "Thirty"
                3 -> "Forty"
                else -> ""
            }

    private fun eitherPlayersOver40() = scorePlayer1.isOverForty() || scorePlayer2.isOverForty()

    private fun isTied() = scorePlayer1 == scorePlayer2
}

data class Score(private var internal: Int = 0) {

    fun next() {
        internal++
    }

    fun isOverForty(): Boolean = internal >= 4
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
