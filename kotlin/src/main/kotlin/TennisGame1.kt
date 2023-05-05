class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var player1Score: Int = 0
    private var player2Score: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            player1Score += 1
        else
            player2Score += 1
    }

    override fun getScore(): String {
        var score = ""
        var tempScore = 0
        if (player1Score == player2Score) {
            score = drawScore()
        } else if (player1Score.isOver40() || player2Score.isOver40()) {
            score = advantagesScore()
        } else {
            for (i in 1..2) {
                if (i == 1)
                    tempScore = player1Score
                else {
                    score += "-"
                    tempScore = player2Score
                }
                when (tempScore) {
                    0 -> score += "Love"
                    1 -> score += "Fifteen"
                    2 -> score += "Thirty"
                    3 -> score += "Forty"
                }
            }
        }
        return score
    }

    private fun advantagesScore(): String {
        val scoreDifference = player1Score - player2Score
        return when {
            scoreDifference == 1 -> "Advantage player1"
            scoreDifference >= 2 -> "Win for player1"
            scoreDifference == -1 -> "Advantage player2"
            else -> "Win for player2"
        }
    }

    private fun Int.isOver40() = this >= 4

    private fun drawScore(): String = when (player1Score) {
        0 -> "Love-All"
        1 -> "Fifteen-All"
        2 -> "Thirty-All"
        else -> "Deuce"
    }
}
