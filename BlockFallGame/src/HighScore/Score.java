/**
 * Score Class
 * 
 * @author Nikki McCloud
 * @version 1.0
 */
package HighScore;

public class Score implements Comparable<Score> {

	// Delcaring Scoring Variables
	private String playerName;
	private String playerScore;

	/**
	 * Default No Args Constructor
	 */
	public Score() {
	}

	/**
	 * Parameterized Constructor
	 * 
	 * @param playerName
	 * @param playerScore
	 */
	public Score(String name, int score) {
		this.playerName = name;
		this.playerScore = Integer.toString(score);
	}

	/**
	 * Getter for playerName
	 * 
	 * @return playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Setter for playerName
	 * 
	 * @param playerName
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * Getter for playerScore
	 * 
	 * @return playerScore
	 */
	public String getPlayerScore() {
		return playerScore;
	}

	/**
	 * Setter for playerScore
	 * 
	 * @param playerScore
	 */
	public void setPlayerScore(String playerScore) {
		this.playerScore = playerScore;
	}

	/**
	 * Get Score Method
	 * 
	 * @param playerScore
	 * @return converts score into int
	 */
	public int getScore() {
		return Integer.parseInt(playerScore);
	}

	/**
	 * Player data is enrypted Method
	 * 
	 * @param shift
	 * @return Shift ceasar cipher
	 */
	public void encryptPlayerData(int shift) {
		playerName = Decoder.Encrypt(playerName, shift);
		playerScore = Decoder.Encrypt(playerScore, shift);
	}

	/**
	 * Player data is decrypted Method
	 * 
	 * @param shift
	 * @return Shift ceasar cipher
	 */
	public void Decrypt(int shift) {
		playerName = Decoder.Decrypt(playerName, shift);
		playerScore = Decoder.Decrypt(playerScore, shift);

	}

	/**
	 * To String Method
	 * 
	 * @param shift
	 * @return player data
	 */
	public String toString() {
		return String.format("%-8s %-3s", playerName, playerScore);
	}

	/**
	 * Compare Score Method
	 * 
	 * @param compareScore
	 * @return negatvie if less than comparison
	 */
	public int compareTo(Score compareScore) {
		return getScore() - compareScore.getScore();
	}
}
