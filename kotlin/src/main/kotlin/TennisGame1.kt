class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var player1Score: Int = 0
    private var player2Score: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name)
            player1Score += 1
        else
            player2Score += 1
    }

    override fun getScore(): String = when {
        isTied() -> tiedScore()
        eitherPlayersOver40() -> finalScore()
        else -> runningGameScore()
    }

    private fun tiedScore(): String =
            when (player1Score) {
                0 -> "Love-All"
                1 -> "Fifteen-All"
                2 -> "Thirty-All"
                else -> "Deuce"
            }

    private fun finalScore(): String {
        val minusResult = player1Score - player2Score
        return when {
            minusResult == 1 -> "Advantage $player1Name"
            minusResult == -1 -> "Advantage $player2Name"
            minusResult >= 2 -> "Win for $player1Name"
            else -> "Win for $player2Name"
        }
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

    private fun eitherPlayersOver40() = player1Score >= 4 || player2Score >= 4

    private fun isTied() = player1Score == player2Score
}
