package JUnitTesting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import HighScore.Score;
import HighScore.ScoreLinkedList;

class ScoreTesting {

	ScoreLinkedList<Score> playerScore;

	/**
	 * Testing Insert Scores in Order
	 * 
	 * 
	 * @return list of scores in order
	 */
	@Test
	public void insertScoresInOrder() {
		playerScore = new ScoreLinkedList<>();
		
		insertScore("JLC", 10,"JLC    10 ");
		insertScore("ENM", 50,"ENM    50 --> JLC    10 ");
		insertScore("KNC", 70,"KNC    70 --> ENM    50 --> JLC    10 ");
	}

	/**
	 * Testing Insert Scores in Reverse Order
	 * 
	 * 
	 * @return list of scores in reverse order
	 */
	@Test
	public void insertScoresInReverseOrder() {
		playerScore = new ScoreLinkedList<>();

		insertScore("JLC", 70,"JLC    70 ");
		insertScore("ENM", 20,"JLC    70 --> ENM    50 ");
		insertScore("KNC", 10,"JLC    70 --> Susan    50 --> KNC    10 ");
	}

	/**
	 * Testing Insert Scores in Reverse Order
	 * 
	 * @param playerName
	 * @param score
	 * @param output
	 * 
	 * @return list of scores in reverse order
	 */
	public void insertScore(String playerName, int score, String output) {
		Score newScore = new Score(playerName, score);
		playerScore.reverseOrder(newScore);
		assertEquals(output, newScore.toString());
	}
}