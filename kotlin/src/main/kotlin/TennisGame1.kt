class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var m_score1: Int = 0
    private var m_score2: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name)
            m_score1 += 1
        else
            m_score2 += 1
    }

    override fun getScore(): String {
        if (m_score1 == m_score2) {
            return when (m_score1) {
                0 -> "Love-All"
                1 -> "Fifteen-All"
                2 -> "Thirty-All"
                else -> "Deuce"
            }
        }
        if (m_score1 >= 4 || m_score2 >= 4) {
            val minusResult = m_score1 - m_score2
            return if (minusResult == 1)
                "Advantage $player1Name"
            else if (minusResult == -1)
                "Advantage $player2Name"
            else if (minusResult >= 2)
                "Win for $player1Name"
            else
                "Win for $player2Name"
        }

        var score = ""
        var tempScore: Int
        for (i in 1..2) {
            if (i == 1)
                tempScore = m_score1
            else {
                score += "-"
                tempScore = m_score2
            }
            when (tempScore) {
                0 -> score += "Love"
                1 -> score += "Fifteen"
                2 -> score += "Thirty"
                3 -> score += "Forty"
            }
        }
        return score
    }
}
