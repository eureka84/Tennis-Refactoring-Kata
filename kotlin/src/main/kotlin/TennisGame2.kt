class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    var P1point: Int = 0
    var P2point: Int = 0

    override fun getScore(): String {
        var score = ""
        if (P1point == P2point && P1point < 4) {
            score = scoreAsString(P1point)
            score += "-All"
        }
        if (P1point == P2point && P1point >= 3)
            score = "Deuce"

        if (P1point > 0 && P2point == 0) {
            score = "${scoreAsString(P1point)}-${scoreAsString(P2point)}"
        }
        if (P2point > 0 && P1point == 0) {
            score = "${scoreAsString(P1point)}-${scoreAsString(P2point)}"
        }

        if (P1point > P2point && P1point < 4) {
            score = "${scoreAsString(P1point)}-${scoreAsString(P2point)}"
        }
        if (P2point > P1point && P2point < 4) {
            score = "${scoreAsString(P1point)}-${scoreAsString(P2point)}"
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage $player1Name"
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage $player2Name"
        }

        if (P1point >= 4 && P2point >= 0 && P1point - P2point >= 2) {
            score = "Win for $player1Name"
        }
        if (P2point >= 4 && P1point >= 0 && P2point - P1point >= 2) {
            score = "Win for $player2Name"
        }
        return score
    }

    private fun scoreAsString(score: Int): String =
            when (score) {
                0 -> "Love"
                1 -> "Fifteen"
                2 -> "Thirty"
                3 -> "Forty"
                else -> ""
            }

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name) {
            P1point++
        } else {
            P2point++
        }
    }
}