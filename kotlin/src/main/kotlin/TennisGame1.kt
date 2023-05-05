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
		isDraw() -> drawScore()
		anyHasAdvantage() -> advantagesScore()
		else -> "${getScoreName(player1Score)}-${getScoreName(player2Score)}"
	}

	private fun anyHasAdvantage() = player1Score.isOver40() || player2Score.isOver40()

	private fun isDraw() = player1Score == player2Score

	private fun getScoreName(tempScore: Int) = when (tempScore) {
		0 -> "Love"
		1 -> "Fifteen"
		2 -> "Thirty"
		3 -> "Forty"
		else -> throw IllegalArgumentException("Temp score cannot be greater than 3")
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
